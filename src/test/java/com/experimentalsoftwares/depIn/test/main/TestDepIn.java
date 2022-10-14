package com.experimentalsoftwares.depIn.test.main;

import com.experimentalsoftwares.depIn.test.cases.classes.ExampleClass;
import com.experimentalsoftwares.depInJava.core.DepIn;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestDepIn {


    @Test
    public void exampleTest(){
    }

    @Test
    public void exampleClass(){

        DepIn depIn = DepIn.JsonContext("src/test/resources/map.json");

        ExampleClass exampleClass = depIn.generateInstance("@example");

        assertNotNull(exampleClass,"Object is null");
    }

}
