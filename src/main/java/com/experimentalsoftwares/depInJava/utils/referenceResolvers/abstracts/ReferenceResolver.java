package com.experimentalsoftwares.depInJava.utils.referenceResolvers.abstracts;

public interface ReferenceResolver {
    <T> Class<T> getTargetClass(String reference);

}
