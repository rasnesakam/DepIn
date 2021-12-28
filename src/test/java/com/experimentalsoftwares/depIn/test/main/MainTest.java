package com.experimentalsoftwares.depIn.test.main;

import com.experimentalsoftwares.depIn.test.cases.abstractClasses.ExampleAbstractClass;
import com.experimentalsoftwares.depIn.test.cases.classes.EmptyClass;
import com.experimentalsoftwares.depIn.test.cases.enums.ExampleEnum;
import com.experimentalsoftwares.depIn.test.cases.interfaces.ExampleInterface;
import com.experimentalsoftwares.depIn.test.cases.recordClasses.ExampleRecord;
import com.experimentalsoftwares.depInJava.core.InstanceBuilder;
import com.experimentalsoftwares.depInJava.utils.exceptions.ClassBuildException;
import org.junit.jupiter.api.Test;

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


}
