package com.experimentalsoftwares.depIn.test.main;

import com.experimentalsoftwares.depIn.test.cases.classes.ExampleClass;
import com.experimentalsoftwares.depInJava.core.DepIn;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestDepIn {

    @Test
    public void exampleClass(){

        DepIn depIn = DepIn.JsonContext("src/test/resources/map.json");

        ExampleClass exampleClass = depIn.getInstance("@example");

        assertNotNull(exampleClass,"Object is null");
    }
}
