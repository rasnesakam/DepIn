package com.experimentalsoftwares.depInJava.utils.mappers.abstracts;

import java.util.List;
import java.util.Map;

/**
 * <h1>ClassMap</h1>
 * <p>
 *     Holds dependencies, values and references from JSON, XML or custom class maps
 * </p>
 *
 * @author Ensar Makas
 * @since 02/09/2021
 */
//TODO XmlClassMap'i implement et
//TODO Builder design ile şaap
public class ClassMap {
    public final String id,name,target;
    public final List<String> args;
    public final Map<String,String> fields;
    public final Map<String,String> setters;


    protected ClassMap(
            String id,
            String name,
            String target,
            List<String> args,
            Map<String,String> fields,
            Map<String, String> setters
    ) {
        this.id = id;
        this.name = name;
        this.target = target;
        this.args = args;
        this.fields = fields;
        this.setters = setters;
    }
}
