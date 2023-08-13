package org.fed333.sql.data.generator.app.service;

import org.fed333.sql.data.generator.app.entity.Phone;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PhoneGenerationService {

    public Phone generatePhone() {
        return Phone.builder().number(generatePhoneNumber()).build();
    }

    public String generatePhoneNumber() {
        SecureRandom random = new SecureRandom();

        StringBuilder sb = new StringBuilder("+38");

        String operatorCode = MobileOperator.values()[random.nextInt(0,3)].getRandomCode();

        sb.append(operatorCode);

        int remainsLength = 7;
        char zero = '0';
        for (int i = 0; i < remainsLength; i++) {
            sb.append((char)(zero+random.nextInt(10)));
        }

        return sb.toString();
    }

    enum MobileOperator {
        KYIVSTAR("067", "068", "096", "097", "098"),
        LIFECELL("063", "073", "093"),
        VODAFONE("050", "066", "095", "099");

        private final List<String> codes;

        MobileOperator(String... codes) {
            this.codes = new ArrayList<>(List.of(codes));
        }

        public List<String> getCodes() {
            return new ArrayList<>(codes);
        }

        public String getRandomCode() {
            Random random = new Random(System.nanoTime());
            return codes.get(random.nextInt(0, codes.size()));
        }

    }

}
