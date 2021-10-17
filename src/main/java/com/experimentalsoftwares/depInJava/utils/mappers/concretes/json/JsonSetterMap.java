package com.experimentalsoftwares.depInJava.utils.mappers.concretes.json;

import com.experimentalsoftwares.depInJava.utils.mappers.abstracts.ArgumentMap;
import com.experimentalsoftwares.depInJava.utils.mappers.abstracts.SetterMap;
import org.json.JSONObject;

public class JsonSetterMap implements SetterMap {

    private String setterName;
    private ArgumentMap arg;

    public JsonSetterMap(JSONObject jsonObject){
    }

    @Override
    public String getSetterName() {
        return this.setterName;
    }

    @Override
    public ArgumentMap getArg() {
        return this.arg;
    }
}
