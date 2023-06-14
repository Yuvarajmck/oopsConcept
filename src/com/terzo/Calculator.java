package com.terzo;


import java.util.*;

public class Calculator {


    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String query = userInput.nextLine();
        String[] num = query.split("[+-/*]");
        String[] opr= query.split("[0-9]");
        int a=0;
        int i=0;
        for(String s:opr) {
            int b = Integer.parseInt(num[i]);
            if (s.equals("+")) {
                a += b;
            } else if (s.equals("-")) {
                a -= b;
            } else if (s.equals("/") && b != 0) {
                if(i==0){
                    a=1;
                }
                a /= b;
            } else {
                if(i==0){
                    a=1;
                }
                a *= b;
            }
            i++;

        }
        if(opr.length==0){
            a+=Integer.parseInt(num[0]);
        }
        System.out.println(a);

    }

}
