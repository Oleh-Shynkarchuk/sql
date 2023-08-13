package org.fed333.sql.data.generator.app.service;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Service
public class NameGenerationService {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    private static final Integer MAX_NAME_LENGTH = 16;
    private static final Integer MIM_NAME_LENGTH = 1;

    public String generateName() {
        SecureRandom random = new SecureRandom();
        int length = random.nextInt(MIM_NAME_LENGTH, MAX_NAME_LENGTH);
        List<Character> name = ALPHABET.chars().mapToObj(c->(char)c).collect(toList());
        Collections.shuffle(name);
        name = name.subList(0, length);
        name.set(0, Character.toUpperCase(name.get(0)));
        return name.stream().map(String::valueOf).collect(Collectors.joining());
    }

}
