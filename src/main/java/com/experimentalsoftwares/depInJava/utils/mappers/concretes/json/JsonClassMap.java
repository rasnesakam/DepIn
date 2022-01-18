package com.experimentalsoftwares.depInJava.utils.mappers.concretes.json;

import com.experimentalsoftwares.depInJava.utils.exceptions.JsonParserException;
import com.experimentalsoftwares.depInJava.utils.mappers.abstracts.ClassMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.experimentalsoftwares.depInJava.utils.mappers.concretes.json.JsonKeys.ClassKeys.*;


// TODO: Builder mantığı getir mapler için.
public class JsonClassMap extends ClassMap {

    private JsonClassMap(
            String id,
            String name,
            String target,
            List<String> args,
            Map<String,String> fields,
            Map<String, String> setters
    ){
        super(id, name, target, args, fields, setters);
    }

    /*
    public JsonClassMap(JSONObject jsonObject) {

        String id = jsonObject.getString(ID);
        String name = jsonObject.getString(REFERENCE);
        String target = jsonObject.getString(TARGET);
        List<String> args = new ArrayList<>();
        Map<String,String> fields = new HashMap<>();
        Map<String,String> setters = new HashMap<>();

        this(id,name,target,args,fields,setters);

    }
    */
}
