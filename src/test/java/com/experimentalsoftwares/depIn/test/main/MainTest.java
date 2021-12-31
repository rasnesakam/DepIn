package com.experimentalsoftwares.depIn.test.main;

import com.experimentalsoftwares.depIn.test.cases.abstractClasses.ExampleAbstractClass;
import com.experimentalsoftwares.depIn.test.cases.classes.EmptyClass;
import com.experimentalsoftwares.depIn.test.cases.classes.ExampleClass;
import com.experimentalsoftwares.depIn.test.cases.enums.ExampleEnum;
import com.experimentalsoftwares.depIn.test.cases.interfaces.ExampleInterface;
import com.experimentalsoftwares.depIn.test.cases.recordClasses.ExampleRecord;
import com.experimentalsoftwares.depInJava.core.InstanceBuilder;
import com.experimentalsoftwares.depInJava.utils.exceptions.ClassBuildException;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testDefaultClass() {
        Exception exception = assertThrows(ClassBuildException.class,()->{
            DefaultClass defaultClass = InstanceBuilder.init(DefaultClass.class).build();
        });

        assertTrue(
                exception.getCause() instanceof IllegalAccessException
                ,String.format(
                        "Thrown exception: %s"
                        ,exception.getCause().getClass().getName()
                )
        );
    }

    @Test
    public void testAbstractClass() {
        Exception exception = assertThrows(ClassBuildException.class,()->{
            ExampleAbstractClass abstractClass = InstanceBuilder.init(ExampleAbstractClass.class).build();
        });

        assertTrue(
                exception.getCause() instanceof InstantiationException
                ,String.format(
                        "Thrown exception: %s"
                        ,exception.getCause().getClass().getName()
                )
        );
    }

    @Test
    public void testInterface() {
        Exception exception = assertThrows(ClassBuildException.class,()->{
            ExampleInterface exampleInterface = InstanceBuilder.init(ExampleInterface.class).build();
        });

        assertTrue(
                exception.getCause() instanceof NoSuchMethodException //Interfaces has no constructor
                ,String.format(
                        "Thrown exception: %s"
                        ,exception.getCause().getClass().getName()
                )
        );
    }

    @Test
    public void testEnums() {
        Exception exception = assertThrows(ClassBuildException.class,()->{
            ExampleEnum exampleEnum = InstanceBuilder.init(ExampleEnum.class).build();
        });

        assertTrue(
                exception.getCause() instanceof NoSuchMethodException // Enum has no public constructor
                ,String.format(
                        "Thrown exception: %s"
                        ,exception.getCause().getClass().getName()
                )
        );
    }

    @Test
    public void testRecords() {
        ExampleRecord record = InstanceBuilder.init(ExampleRecord.class).withArgs("Selam").build();

        assertNotNull(record,"Created instance is null");
        assertNotNull(record.arg(),"Arg of created instance is null");
    }

    @Test
    public void testEmptyClass() {
        EmptyClass emptyClass = InstanceBuilder.init(EmptyClass.class).build();

        assertNotNull(emptyClass,"Created instance is null");
    }

    @Test
    public void testConstructor(){
        /*
        ExampleClass ec = InstanceBuilder.init(ExampleClass.class).withArgs("Selam").build();
        assertNotNull(ec,"Object is null");
        assertNotNull(ec.getDependency());
        assertEquals("Selam", ec.getDependency(),"Example class dependency is wrong!");

         */
    }

    @Test
    public void testPrivateFields(){
        Map<String,Object> fieldsMap = new HashMap<>();
        fieldsMap.put("dependency","Selam");
        fieldsMap.put("secretString","gizli");

        ExampleClass ec = InstanceBuilder.init(ExampleClass.class).withArgs("Aleykümselam").withFields(fieldsMap).build();

        System.out.println(ec.getDependency());

        assertNotNull(ec,"Object is null");
        assertNotNull(ec.getDependency());
        assertNotNull(ec.getSecretString());
        assertEquals("Selam", ec.getDependency(),"Example class dependency is wrong!");
        assertEquals("gizli", ec.getSecretString(),"Example class dependency is wrong!");
    }

    @Test
    public void testPublicFields(){
        /*
        Map<String,Object> fieldsMap = new HashMap<>();
        fieldsMap.put("publicDependency","Selam");

        ExampleClass ec = InstanceBuilder.init(ExampleClass.class).withFields(fieldsMap).build();

        assertNotNull(ec,"Object is null");
        assertNotNull(ec.publicDependency);
        assertEquals("Selam", ec.publicDependency,"Example class dependency is wrong!");
        */
    }
    @Test
    public void testSetterInjection(){
        /*
        Map<String,Object> setterMap = new TreeMap<>();
        setterMap.put("setDependency","Selam");
        ExampleClass ec = InstanceBuilder.init(ExampleClass.class).withSetters(setterMap).build();

        assertNotNull(ec,"Object is null");
        assertNotNull(ec.getDependency());
        assertEquals("Selam", ec.getDependency(),"Example class dependency is wrong!");

         */
    }

}
