package org.fed333.sql.data.generator.app.rule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.util.Objects;

public class RepeatedTestRule implements TestRule {

    @Override
    public Statement apply(Statement statement, Description description) {
        Repeat repeat = description.getAnnotation(Repeat.class);
        Statement result = statement;
        if (Objects.nonNull(repeat)) {
            result = new RepeatableTestStatement(repeat.times(), statement);
        }
        return result;
    }
}
