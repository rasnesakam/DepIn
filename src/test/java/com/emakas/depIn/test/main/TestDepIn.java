package com.emakas.depIn.test.main;

import com.emakas.depIn.test.cases.case1.classes.ExampleClass;
import com.emakas.depIn.core.DepIn;
import com.emakas.depIn.test.cases.case2.service.Service;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class TestDepIn {


    @Test
    public void exampleTest(){
    }

    @Test
    public void exampleClass(){

        DepIn depIn = DepIn.jsonContext("src/test/resources/map.json");

        ExampleClass exampleClass = depIn.generateInstance("@example");

        assertNotNull(exampleClass,"Object is null");
    }

    @Test
    public void exampleDbAction(){
        DepIn depIn = DepIn.jsonContext("src/test/resources/map.json");

        assertDoesNotThrow(() -> {
            Service service = depIn.generateInstance("#" + Service.class.getName());
            assertNotNull(service,"Service should not be null");
            assertEquals(service.getAll().get(0),"Hello, DepIn","Something went wrong");
        },"Test should not throw an exception");
    }

}
