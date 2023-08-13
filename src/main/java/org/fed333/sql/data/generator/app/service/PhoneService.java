package org.fed333.sql.data.generator.app.service;

import lombok.RequiredArgsConstructor;
import org.fed333.sql.data.generator.app.entity.Phone;
import org.fed333.sql.data.generator.app.repository.PhoneRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhoneService {

    private final PhoneRepository phoneRepo;

    public Phone save(Phone phone) {
        return phoneRepo.save(phone);
    }

    public void deleteAll() {
        phoneRepo.deleteAll();
    }
}
