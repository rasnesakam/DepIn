package com.experimentalsoftwares.depIn.test.main;

import org.json.JSONArray;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void test1() {

        try {
            String str = "";
            Scanner scanner = new Scanner(new FileInputStream("src/test/resources/map.json"));
            while (scanner.hasNextLine()) str = str.concat(scanner.nextLine());

            JSONArray array = new JSONArray(str);

            System.out.println(array.getJSONObject(0).toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
