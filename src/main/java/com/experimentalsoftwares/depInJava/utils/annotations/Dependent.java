package com.experimentalsoftwares.depInJava.utils.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * <h1>@Dependent</h1>
 * <p>Using to notate the fields that depended for instance</p>
 * @author Ensar Makas
 * @since 22.08.2021
 * @version 1.0
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Dependent {
}
