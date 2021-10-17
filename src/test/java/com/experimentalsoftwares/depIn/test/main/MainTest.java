package com.experimentalsoftwares.depIn.test.main;

import org.json.JSONArray;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void test1() {

        if(a() && b());
        System.out.println("finished : &&");

        if(a() & b());
        System.out.println("finished : &");

        if(a() || b());
        System.out.println("finished : ||");


        if(a() | b());
        System.out.println("finished : |");
    }

    public boolean a(){
        System.out.println("executed: a");
        return false;
    }
    public boolean b(){
        System.out.println("executed: b");
        return false;
    }
}
