package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Calcul {
    public static String calc(String expression) throws Exception {
        String[] s = expression.split(" ");
        Stack<String> stack = new Stack<String>();
        String left, right;
        for (String item : s) {
            switch (item) {
                case "+": {
                    right = stack.pop();
                    left = stack.pop();
                    Integer r = (Integer.parseInt(left) + Integer.parseInt(right));
                    stack.push(r.toString());
                    break;
                }
                case "-": {
                    right = stack.pop();
                    left = stack.pop();
                    Integer r = (Integer.parseInt(left) - Integer.parseInt(right));
                    stack.push(r.toString());
                    break;
                }
                case "*": {
                    right = stack.pop();
                    left = stack.pop();
                    Integer r = (Integer.parseInt(left) * Integer.parseInt(right));
                    stack.push(r.toString());
                    break;
                }
                case "/": {
                    right = stack.pop();
                    left = stack.pop();
                    if (right == "0") throw new Exception("zero exception");
                    Integer r = (Integer.parseInt(left) / Integer.parseInt(right));
                    break;
                }
            }

        }
        return stack.pop();
    }
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static String calculator(String expression){
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        map.put("+",1);
        map.put("-",1);
        map.put("*",2);
        map.put("/",2);

        Stack<String>stack= new Stack<String>();
        String out="";
        ArrayList<String > s=new ArrayList<String>();
        String[] exp=expression.split(" ");
        for (String item:exp) {
            s.add(item);
        }
        String c;

        for (int i = 0; i < s.size();i++) {
            c = s.get(i);

            if (isNumeric(c)) {
                out+=c+" ";
            } else if (c.equals("(")) {
                stack.push(c);
            }

            else if (c.equals(")")) {

                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    out+=stack.pop()+" ";
                }
                if (!stack.isEmpty() && !stack.peek().equals("("))
                    return null;
                else if(!stack.isEmpty())
                    stack.pop();
            }
            else if (map.containsKey(c) )
            {

                if (!stack.isEmpty() && map.get(c) <= (map.containsKey(stack.peek())?map.get(stack.peek()):-1)) {
                    out+=stack.pop()+" ";
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            out+=stack.pop()+" ";
        }
        return out;
    }

}
