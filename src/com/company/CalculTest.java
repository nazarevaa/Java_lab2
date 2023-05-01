package com.company;

import static com.company.Calcul.calculator;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculTest {

    @Test
    void check1() throws Exception {
        String str="7 + 65 * 2";
        assertEquals("137",Calcul.calc(calculator(str)));
    }
    @Test
    void check2() throws Exception {
        String str="20 - 20 + 20";
        Calcul  calc =new Calcul ();
        assertEquals("20",Calcul.calc(calculator(str)));
    }

    @Test
    void check3() throws Exception {
        String str="fkroep/9";
        Calcul  calc =new Calcul();
        assertEquals("Error",Calcul.calc(calculator(str)));
    }
    @Test
    void check4() {
        String str="(345+45)/2";
        Calcul  calc =new Calcul ();
        assertNotEquals("6",calc.calculator(str));
    }


}