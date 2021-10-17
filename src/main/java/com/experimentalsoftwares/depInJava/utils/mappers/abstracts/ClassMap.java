package com.experimentalsoftwares.depInJava.utils.mappers.abstracts;

import java.util.List;

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
public interface ClassMap {
    String getId();
    String getReferenceClassName();
    String getTargetClassName();
    ConstructorMap getConstructor();
    List<FieldMap> getFields();
    List<SetterMap> getSetters();
}
