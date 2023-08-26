package com.emakas.depIn.utils.mappers.maps;

import com.emakas.depIn.utils.exceptions.JsonParserException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

import static com.emakas.depIn.utils.mappers.keys.json.JsonKeys.*;

public class MapBuilder {
    public static ClassMaps fromJsonMap(String jsonFile){
        String jsonSource = "";
        try {
            Scanner scanner = new Scanner(new FileInputStream(jsonFile));
            // Read all json data
            while (scanner.hasNextLine()){
                jsonSource = jsonSource.concat(scanner.nextLine());
            }

            // Create json array from json data
            JSONArray array = new JSONArray(jsonSource);

            // Create list for classmaps
            List<ClassMap> classMaps = new ArrayList<>();

            // navigate through all objects of json array
            for (int i = 0; i < array.length(); i++){

                JSONObject jsonObject = array.getJSONObject(i);
                // Create dependents for ClassMap (id, ref, target, args, fields, sets)
                String id, ref, target;
                List<String> args = new ArrayList<>();
                Map<String,String> fields = new HashMap<>();
                Map<String,String> sets = new HashMap<>();

                // Fill id, ref and target if they are exists
                id = jsonObject.has(ID) ?
                        jsonObject.getString(ID) : null;
                ref = jsonObject.has(REF) ?
                        jsonObject.getString(REF) : null;
                // Target field is required. If it is null, will be thrown an exceprion
                target = jsonObject.has(TARGET) ?
                        jsonObject.getString(TARGET) : null;
                if (target == null)
                    throw JsonParserException.withCustomMessage("Field 'target' is required");
                // Fill args from json object
                if (jsonObject.has(ARGS))
                    jsonObject.getJSONArray(ARGS).forEach(arg -> {
                        args.add(arg.toString());
                    });

                // Fill fields from json object
                if (jsonObject.has(FIELDS))
                    jsonObject.getJSONArray(FIELDS).forEach(fieldRaw ->{
                        JSONObject field = (JSONObject) fieldRaw;
                        field.toMap().forEach((k,v)-> fields.put(k,v.toString()) );
                    });

                // Fill setters from json object
                if (jsonObject.has(SET))
                    jsonObject.getJSONArray(SET).forEach(setRaw -> {
                        JSONObject set = (JSONObject) setRaw;
                        set.toMap().forEach((k,v)-> sets.put(k,v.toString()));
                    });

                // Create new ClassMap and add to list
                classMaps.add(
                        new ClassMap(
                                id,
                                ref,
                                target,
                                args,
                                fields,
                                sets
                        )
                );
            }

            // Create new ClassMaps with created list and return it
            return new ClassMaps(classMaps);

        } catch (FileNotFoundException e) {
            throw JsonParserException.invalidJsonString(e);
        } catch (JSONException e){
            throw JsonParserException.invalidJsonObject(e);
        }
    }
}
