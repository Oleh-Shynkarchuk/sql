package org.fed333.sql.data.generator.app.repository;

import org.fed333.sql.data.generator.app.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer> {
}
