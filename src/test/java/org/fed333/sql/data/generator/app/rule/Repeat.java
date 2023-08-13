package org.fed333.sql.data.generator.app.rule;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Repeat {

    int times();

}
