package com.experimentalsoftwares.depInJava.utils.referenceMappers.concretes.json;

import com.experimentalsoftwares.depInJava.utils.referenceMappers.abstracts.ArgumentMap;
import com.experimentalsoftwares.depInJava.utils.referenceMappers.abstracts.SetterMap;
import static com.experimentalsoftwares.depInJava.utils.referenceMappers.concretes.json.JsonKeys.SetterKeys.*;
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
