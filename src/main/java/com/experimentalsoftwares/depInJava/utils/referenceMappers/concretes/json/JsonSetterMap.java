package com.experimentalsoftwares.depInJava.utils.referenceMappers.concretes.json;

import com.experimentalsoftwares.depInJava.utils.referenceMappers.abstracts.ArgumentMap;
import com.experimentalsoftwares.depInJava.utils.referenceMappers.abstracts.SetterMap;
import org.json.JSONObject;

public class JsonSetterMap implements SetterMap {

    public JsonSetterMap(JSONObject jsonObject){

    }

    @Override
    public String getSetterName() {
        return null;
    }

    @Override
    public ArgumentMap getArg() {
        return null;
    }
}
