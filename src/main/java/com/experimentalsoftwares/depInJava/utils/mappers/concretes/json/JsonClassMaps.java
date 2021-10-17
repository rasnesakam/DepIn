package com.experimentalsoftwares.depInJava.utils.mappers.concretes.json;

import com.experimentalsoftwares.depInJava.utils.exceptions.JsonParserException;
import com.experimentalsoftwares.depInJava.utils.mappers.abstracts.ClassMap;
import com.experimentalsoftwares.depInJava.utils.mappers.abstracts.ClassMaps;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JsonClassMaps implements ClassMaps {

    private String JsonString = "";

    public JsonClassMaps(String jsonFile) {
        try {
            Scanner scanner = new Scanner(new FileInputStream(jsonFile));
            while (scanner.hasNextLine()) JsonString = JsonString.concat(scanner.nextLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ClassMap> getClassMaps() {
        try{
            JSONArray array = new JSONArray(JsonString);
            ArrayList<ClassMap> maps = new ArrayList<>();
            for(int i = 0; i < array.length(); i++){
                maps.add(new JsonClassMap(array.getJSONObject(i)));
            }
            return maps;
        }
        catch (JSONException exception){
            throw JsonParserException.invalidJsonString(exception);
        }

    }
}
