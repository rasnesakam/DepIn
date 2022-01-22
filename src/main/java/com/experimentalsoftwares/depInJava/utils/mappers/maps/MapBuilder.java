package com.experimentalsoftwares.depInJava.utils.mappers.maps;

import com.experimentalsoftwares.depInJava.utils.mappers.keys.json.JsonKeys;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

import static com.experimentalsoftwares.depInJava.utils.mappers.keys.json.JsonKeys.*;

public class MapBuilder {
    public static ClassMaps fromJsonMap(String jsonFile){
        String jsonSource = "";
        try {
            Scanner scanner = new Scanner(new FileInputStream(jsonFile));
            while (scanner.hasNextLine()){
                jsonSource = jsonSource.concat(scanner.nextLine());
            }
            JSONArray array = new JSONArray(jsonSource);
            List<ClassMap> classMaps = new ArrayList<>();
            array.forEach(obj -> {
                JSONObject jsonObject = new JSONObject(obj);

                List<String> args = new ArrayList<>();
                Map<String,String> fields = new HashMap<>();
                Map<String,String> sets = new HashMap<>();

                if (jsonObject.has(ClassKeys.ARGS))
                    jsonObject.getJSONArray(ClassKeys.ARGS).forEach(arg -> {
                        args.add(arg.toString());
                    });
                if (jsonObject.has(ClassKeys.FIELDS))
                    jsonObject.getJSONArray(ClassKeys.FIELDS).forEach(fieldRaw ->{
                        JSONObject field = new JSONObject(fieldRaw);
                        fields.put(field.getString(ValueKeys.NAME),field.getString(ValueKeys.VALUE));
                    });
                if (jsonObject.has(ClassKeys.SET))
                    jsonObject.getJSONArray(ClassKeys.SET).forEach(setRaw -> {
                        JSONObject set = new JSONObject(setRaw);
                        sets.put(set.getString(ValueKeys.NAME),set.getString(ValueKeys.VALUE));
                    });

                classMaps.add(
                        new ClassMap(
                                jsonObject.getString(ClassKeys.ID),
                                jsonObject.getString(ClassKeys.NAME),
                                jsonObject.getString(ClassKeys.TARGET),
                                args,
                                fields,
                                sets
                        )
                );
            });
            return new ClassMaps(classMaps);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
