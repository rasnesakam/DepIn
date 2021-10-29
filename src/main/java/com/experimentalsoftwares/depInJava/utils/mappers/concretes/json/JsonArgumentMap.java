package com.experimentalsoftwares.depInJava.utils.mappers.concretes.json;

import com.experimentalsoftwares.depInJava.utils.exceptions.JsonParserException;
import com.experimentalsoftwares.depInJava.utils.mappers.abstracts.ArgumentMap;
import static com.experimentalsoftwares.depInJava.utils.mappers.concretes.json.JsonKeys.ArgumentKeys.*;
import org.json.JSONObject;

public class JsonArgumentMap implements ArgumentMap {
    private String refer;
    private String fromId;
    private String value;

    public JsonArgumentMap(JSONObject jsonObject){
        if(jsonObject.has(REFER) || jsonObject.has(FROM_ID) || jsonObject.has(VALUE)){

            if(jsonObject.has(REFER)) this.refer = jsonObject.getString(REFER);
            if(jsonObject.has(FROM_ID)) this.refer = jsonObject.getString(FROM_ID);
            if(jsonObject.has(VALUE)) this.refer = jsonObject.getString(VALUE);

        }
        else throw JsonParserException.invalidJsonObject(null);
    }

    @Override
    public String getRefer() {
        return this.refer;
    }

    @Override
    public String getFromId() {
        return this.fromId;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
