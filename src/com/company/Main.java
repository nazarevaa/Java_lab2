package com.company;

import java.util.*;

import static com.company.Calcul.calculator;

public class Main {


    public static void main(String[] args) throws Exception {
        String s="567 + 90 * 2 + 81 / 9";
        System.out.println(Calcul.calc(calculator(s)));
        s="( 0 + 1 ) * 23 - 10 / ( 9 + 1 )";
        System.out.println(Calcul.calc(calculator(s)));
        s="99/0";
        System.out.println(Calcul.calc(calculator(s)));
        s="akjfjewf/8";
        System.out.println(Calcul.calc(calculator(s)));
        s="34 * 2 + 625 / 5 - 7 * 400";
        System.out.println(Calcul.calc(calculator(s)));
    }
}