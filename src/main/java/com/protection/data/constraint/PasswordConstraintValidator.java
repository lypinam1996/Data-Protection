package com.protection.data.constraint;

import org.passay.*;
import org.passay.dictionary.WordListDictionary;
import org.passay.dictionary.WordLists;
import org.passay.dictionary.sort.ArraysSort;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    private DictionaryRule dictionaryRule;

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
        try {
            String invalidPasswordList = "invalid-password-list.txt";
            FileWriter writer = new FileWriter(invalidPasswordList);
            writer.write("azerty12!");
            writer.close();
            dictionaryRule = new DictionaryRule(
                    new WordListDictionary(WordLists.createFromReader(
                            new FileReader[] {
                                    new FileReader(invalidPasswordList)
                            },
                            false,
                            new ArraysSort()
                    )));
        } catch (IOException e) {
            throw new RuntimeException("could not load word list", e);
        }
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        PasswordValidator validator = new PasswordValidator(Arrays.asList(

                // at least one upper-case character
                new CharacterRule(EnglishCharacterData.UpperCase, 1),

                // at least one lower-case character
                new CharacterRule(EnglishCharacterData.LowerCase, 1),

                // at least one digit character
                new CharacterRule(EnglishCharacterData.Digit, 1),

                // at least one symbol (special character)
                new CharacterRule(EnglishCharacterData.Special, 1),

                // no whitespace
                new WhitespaceRule(),

                // no common passwords
                dictionaryRule
        ));

        RuleResult result = validator.validate(new PasswordData(password));
        if (result.isValid()) {
            return true;
        }

        List<String> messages = validator.getMessages(result);
        for (int i=0;i<messages.size();i++){
            if(messages.get(i).contains("Password must contain 1 or more uppercase characters")){
                messages.remove(messages.get(i));
                messages.add(i,"Пароль должен содержать 1 или более заглавных латинских букв \n");
            }
            if(messages.get(i).contains("Password must contain 1 or more lowercase characters")){
                messages.remove(messages.get(i));
                messages.add(i,"Пароль должен содержать 1 или более строчных латинских букв \n");
            }
            if(messages.get(i).contains("Password must contain 1 or more special characters")){
                messages.remove(messages.get(i));
                messages.add(i,"Пароль должен содержать 1 или более спец. символов (!, ? и т.д) \n");
            }
            if(messages.get(i).contains("Password must contain 1 or more digit characters")){
                messages.remove(messages.get(i));
                messages.add(i,"Пароль должен содержать 1 или более цифру \n");
            }
        }

        String messageTemplate = messages.stream().collect(Collectors.joining("~"));
        context.buildConstraintViolationWithTemplate(messageTemplate)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}

























