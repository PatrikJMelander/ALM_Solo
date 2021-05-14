package com.example.springdocker;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyMathCalcTest {

    @BeforeAll
    public static void init(){
        System.out.println("Om man vill lägga till saker innan testerna");
    }
    @BeforeEach
    public void beforeMethod(){
        System.out.println("Gör saker innan varje test");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("Om man vill göra något efter alla tester");
    }
    @AfterEach
    public void afterMethod(){
        System.out.println("Om man vill göra något efter varje test");
    }



    @Test
    public void addTest(){
        MyMathCalc myMathCalc = new MyMathCalc();
        int expected = 5;
        int actual = myMathCalc.add(2, 3);

        assertEquals(expected, actual);

    }

    @Test
    public void multiplyTest(){
        MyMathCalc myMathCalc = new MyMathCalc();
        int expected = 6;
        int actual = myMathCalc.multiply(2, 3);

        assertEquals(expected, actual);

    }

    @Test
    public void dividedTest(){
        MyMathCalc myMathCalc = new MyMathCalc();
        int expected = 3;
        double actual = myMathCalc.divided(6, 2);

        assertEquals(expected, actual);

    }
    @Test
    void divideThrow() {
        MyMathCalc myMathCalc = new MyMathCalc();
        assertThrows(ArithmeticException.class, () -> myMathCalc.divided(0, 2));
    }
}
