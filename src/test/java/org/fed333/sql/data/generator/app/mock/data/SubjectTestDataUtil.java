package org.fed333.sql.data.generator.app.mock.data;

import org.fed333.sql.data.generator.app.entity.Subject;

import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

public class SubjectTestDataUtil {

    public static <T extends Collection<Subject>> T testSubjects(Supplier<T> collectionSupplier) {
        T collection =  collectionSupplier.get();
        collection.addAll(List.of(
                createSubjectWithNameAndTutor("subject 1", "tutor 1"),
                createSubjectWithNameAndTutor("subject 2", "tutor 2"),
                createSubjectWithNameAndTutor("subject 3", "tutor 3"),
                createSubjectWithNameAndTutor("subject 4", "tutor 4"),
                createSubjectWithNameAndTutor("subject 5", "tutor 5")
        ));
        return collection;
    }

    private static Subject createSubjectWithNameAndTutor(String name, String tutor) {
        return Subject.builder()
                .name(name)
                .tutor(tutor)
                .build();
    }

}
