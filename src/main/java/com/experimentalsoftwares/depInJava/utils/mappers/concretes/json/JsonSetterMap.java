package com.experimentalsoftwares.depInJava.utils.mappers.concretes.json;

import com.experimentalsoftwares.depInJava.utils.exceptions.JsonParserException;
import com.experimentalsoftwares.depInJava.utils.mappers.abstracts.ArgumentMap;
import com.experimentalsoftwares.depInJava.utils.mappers.abstracts.SetterMap;
import static com.experimentalsoftwares.depInJava.utils.mappers.concretes.json.JsonKeys.SetterKeys.*;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonSetterMap implements SetterMap {

    private String setterName;
    private ArgumentMap arg;

    public JsonSetterMap(JSONObject jsonObject){
        try{
            this.setterName = jsonObject.getString(SETTER_NAME);
            this.arg = new JsonArgumentMap(jsonObject);
        }
        catch (JSONException e){
            throw JsonParserException.invalidJsonObject(e);
        }
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
