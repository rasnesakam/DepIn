package com.experimentalsoftwares.depInJava.utils.referenceMappers.abstracts;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * <h1>ClassMaps</h1>
 * <p>
 *     Holds maps of classes from JSON, XML or ClassMap classes
 * </p>
 * @author Ensar
 * @since 02/09/2021
 */

// TODO XmlClassMaps'i implement et
public interface ClassMaps {

    List<ClassMap> getClassMaps();

    default List<ClassMap> getClassMapsBy(Predicate<ClassMap> predicate){
        return getClassMaps().parallelStream().filter(predicate).collect(Collectors.toList());
    }
    default ClassMap getClassMapBy(Predicate<ClassMap> predicate){
        ClassMap[] map = new ClassMap[1];
        getClassMaps().parallelStream().forEach(cm -> {
            if(predicate.test(cm)) map[0] = cm;
        });
        return map[0];
    }
}
