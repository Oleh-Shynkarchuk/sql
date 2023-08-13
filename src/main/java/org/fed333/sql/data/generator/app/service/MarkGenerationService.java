package org.fed333.sql.data.generator.app.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class MarkGenerationService {

    public Short generateMark() {
        return (short) ThreadLocalRandom.current()
                .nextInt(1, 11);
    }

}
