package com.experimentalsoftwares.depInJava.utils.referenceMappers.concretes.json;


class JsonKeys {
    static class ClassKeys{
        static final String
                ID = "id",
                REFERENCE = "reference",
                TARGET = "target",
                FIELDS = "fields",
                CONSTRUCTORS = "constructors",
                SETTERS = "setters";
    }
    static class ConstructorKeys{
        static final String
                TAG = "tag",
                ARGS = "args";
    }
    static class FieldKeys{
        static final String
                FIELD_NAME = "fieldName",
                ARG = "arg";
    }
    static class ArgumentKeys{
        static final String
                REFER = "refer",
                FROM_ID = "fromId",
                VALUE = "value";
    }
    static class SetterKeys{
        static final String
                SETTER_NAME = "setterName",
                ARG = "arg";
    }
}
