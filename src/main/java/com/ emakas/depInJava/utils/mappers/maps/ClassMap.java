package com.experimentalsoftwares.depInJava.utils.mappers.maps;

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
    public final String id,ref,target;
    public final List<String> args;
    public final Map<String,String> fields;
    public final Map<String,String> setters;


    protected ClassMap(
            String id,
            String ref,
            String target,
            List<String> args,
            Map<String,String> fields,
            Map<String, String> setters
    ) {
        this.id = id;
        this.ref = ref;
        this.target = target;
        this.args = args;
        this.fields = fields;
        this.setters = setters;
    }


}
