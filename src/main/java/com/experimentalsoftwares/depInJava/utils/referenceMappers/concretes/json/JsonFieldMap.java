package com.experimentalsoftwares.depInJava.utils.referenceMappers.concretes.json;

import com.experimentalsoftwares.depInJava.utils.referenceMappers.abstracts.ArgumentMap;
import com.experimentalsoftwares.depInJava.utils.referenceMappers.abstracts.FieldMap;
import org.json.JSONObject;

public class JsonFieldMap implements FieldMap {

    public JsonFieldMap(JSONObject jsonObject){

    }

    @Override
    public String getFieldName() {
        return null;
    }

    @Override
    public ArgumentMap getArg() {
        return null;
    }
}
