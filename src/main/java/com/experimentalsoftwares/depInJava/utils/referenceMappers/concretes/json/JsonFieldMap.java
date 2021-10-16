package com.experimentalsoftwares.depInJava.utils.referenceMappers.concretes.json;
import com.experimentalsoftwares.depInJava.utils.exceptions.JsonParserException;
import com.experimentalsoftwares.depInJava.utils.referenceMappers.abstracts.ArgumentMap;
import com.experimentalsoftwares.depInJava.utils.referenceMappers.abstracts.FieldMap;
import org.json.JSONException;
import org.json.JSONObject;
import static com.experimentalsoftwares.depInJava.utils.referenceMappers.concretes.json.JsonKeys.FieldKeys.*;

public class JsonFieldMap implements FieldMap {

    private final String name;
    private final ArgumentMap argumentMap;

    public JsonFieldMap(JSONObject jsonObject){
        try{
            this.name = jsonObject.getString(FIELD_NAME);
            this.argumentMap = new JsonArgumentMap(jsonObject.getJSONObject(ARG));
        }
        catch (JSONException exception){
            throw JsonParserException.invalidJsonObject(exception);
        }
    }

    @Override
    public String getFieldName() {
        return this.name;
    }

    @Override
    public ArgumentMap getArg() {
        return this.argumentMap;
    }
}
