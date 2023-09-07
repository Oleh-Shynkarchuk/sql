package org.fed333.sql.data.generator.app;

import lombok.extern.slf4j.Slf4j;
import org.fed333.sql.data.generator.app.entity.Phone;
import org.fed333.sql.data.generator.app.entity.Student;
import org.fed333.sql.data.generator.app.service.StudentService;
import org.fed333.sql.data.generator.app.service.SubjectService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.persistence.FetchType;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
