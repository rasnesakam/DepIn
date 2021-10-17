package com.experimentalsoftwares.depInJava.utils.mappers.concretes.json;

import com.experimentalsoftwares.depInJava.utils.exceptions.JsonParserException;
import com.experimentalsoftwares.depInJava.utils.mappers.abstracts.ClassMap;
import com.experimentalsoftwares.depInJava.utils.mappers.abstracts.ConstructorMap;
import com.experimentalsoftwares.depInJava.utils.mappers.abstracts.FieldMap;
import com.experimentalsoftwares.depInJava.utils.mappers.abstracts.SetterMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import static com.experimentalsoftwares.depInJava.utils.mappers.concretes.json.JsonKeys.ClassKeys.*;

public class JsonClassMap implements ClassMap {

    private final String id;
    private final String referenceClassName;
    private final String targetClassName;
    private final List<FieldMap> fieldMaps;
    private final ConstructorMap constructorMap;
    private final List<SetterMap> setterMaps;

    public JsonClassMap(JSONObject jsonObject) {

        try{
            this.id = jsonObject.getString(ID);
            this.referenceClassName = jsonObject.getString(REFERENCE);
            this.targetClassName = jsonObject.getString(TARGET);

            this.fieldMaps = new ArrayList<>();
            if (jsonObject.has(FIELDS)){
                JSONArray array = jsonObject.getJSONArray(FIELDS);
                for (int i = 0; i < array.length(); i ++)
                    fieldMaps.add(new JsonFieldMap(array.getJSONObject(i)));
            }

            this.constructorMap = jsonObject.has(CONSTRUCTOR) ? new JsonConstructorMap(jsonObject.getJSONObject(CONSTRUCTOR)) : null ;

            this.setterMaps = new ArrayList<>();
            if (jsonObject.has(SETTERS)){
                JSONArray array = jsonObject.getJSONArray(SETTERS);
                for (int i = 0; i < array.length(); i ++)
                    setterMaps.add(new JsonSetterMap(array.getJSONObject(i)));
            }
        }
        catch (JSONException exception){
            throw JsonParserException.invalidJsonObject(exception);
        }

    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getReferenceClassName() {
        return this.referenceClassName;
    }

    @Override
    public String getTargetClassName() {
        return this.targetClassName;
    }

    @Override
    public List<FieldMap> getFields() {
        return this.fieldMaps;
    }

    @Override
    public ConstructorMap getConstructor() {
        return this.constructorMap;
    }

    @Override
    public List<SetterMap> getSetters() {
        return this.setterMaps;
    }
}
