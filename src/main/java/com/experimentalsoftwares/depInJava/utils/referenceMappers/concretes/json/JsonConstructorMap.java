package com.experimentalsoftwares.depInJava.utils.referenceMappers.concretes.json;

import com.experimentalsoftwares.depInJava.utils.exceptions.ClassBuildException;
import com.experimentalsoftwares.depInJava.utils.exceptions.JsonParserException;
import com.experimentalsoftwares.depInJava.utils.referenceMappers.abstracts.ArgumentMap;
import com.experimentalsoftwares.depInJava.utils.referenceMappers.abstracts.ConstructorMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import static com.experimentalsoftwares.depInJava.utils.referenceMappers.concretes.json.JsonKeys.ConstructorKeys.*;
import java.util.ArrayList;
import java.util.List;

public class JsonConstructorMap implements ConstructorMap {

    private final String tag;
    private final List<ArgumentMap> argumentMaps;

    public JsonConstructorMap(JSONObject jsonObject){
        try{
            this.tag = jsonObject.getString(TAG);

            this.argumentMaps = new ArrayList<>();
            JSONArray array = jsonObject.getJSONArray(ARGS);
            for (int i = 0; i < array.length(); i ++)
                argumentMaps.add(new JsonArgumentMap(array.getJSONObject(i)));
        }
        catch (JSONException exception){
            throw JsonParserException.invalidJsonObject(exception);
        }
    }

    @Override
    public String getTag() {
        return this.tag;
    }

    @Override
    public List<ArgumentMap> getArgs() {
        return this.argumentMaps;
    }
}
