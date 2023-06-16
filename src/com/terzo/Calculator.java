package com.terzo;


import java.util.*;

public class Calculator extends Exception{
    private static double doSimplMath(int start, int end, String[] opr, String[] num){
        double a=Integer.parseInt(num[start]);
        try{
            int j=start;

        for (int i=start;i<end;i++) {

            int b = Integer.parseInt(num[j]);
            if (opr[i].equals("+")) {
                a += b;
            } else if (opr[i].equals("-")) {
                a -= b;
            } else if (opr[i].equals("/") && b != 0) {
                if (i == 0) {
                    a = 1;
                }
                a /= b;
            }
            else if(opr[i].length()==2){
                int st = i;
                while(opr[i].equals(")")){
                    i++;
                }
                int en=i-1;
                char temp = opr[i].charAt(0);

                if(temp == '+'){
                    a+=(doSimplMath(st,en,opr,num));
                }else if(temp == '-'){
                    a-=(doSimplMath(st,en,opr,num));
                }else if(temp == '*'){
                    a*=(doSimplMath(st,en,opr,num));
                }else if(temp == '/'){
                    a/=(doSimplMath(st,en,opr,num));
                }
            }
            else if(opr[i].equals("*")){
                if (i == 0) {
                    a = 1;
                }
                a *= b;
            }
            else{
                i++;
                j++;
                continue;
            }
            i++;
            j++;
        }
        if (opr.length == 0) {
            a += Integer.parseInt(num[0]);
        }


    }catch (Exception e){
            int y=0;
    }
        return a;
    }
    private static double doMathsWithBraces(String query){

        String[] num = query.split("[+-/*()]");
        String[] opr= query.split("[0-9]");
        double a=Integer.parseInt(num[0]);
        int i=1;
        try{
            for (String s : opr) {

                if(s==""){
                    i++;
                    continue;
                }
                int b;
                if(num[i]!=""){
                    b = Integer.parseInt(num[i]);
                }
                else{
                    i++;
                    b=0;
                }
                if (s.equals("+")) {
                    a += b;
                } else if (s.equals("-")) {
                    a -= b;
                } else if (s.equals("/") && b != 0) {
                    if (i == 0) {
                        a = 1;
                    }
                    a /= b;
                }
                else if(s.length()==2){
                    int start = 0+i;

                    while(!opr[i].equals(")")){
                        i++;
                    }

                    int end=i;
                    char temp = s.charAt(0);
                    if(temp == '+'){
                        a+=(doSimplMath(start,end,opr,num));
                    }else if(temp == '-'){
                        a-=(doSimplMath(start,end,opr,num));
                    }else if(temp == '*'){
                        a*=(doSimplMath(start,end,opr,num));
                    }else if(temp == '/'){
                        a/=(doSimplMath(start,end,opr,num));
                    }

                }
                else {
                    if (i == 0) {
                        a = 1;
                    }
                    a *= b;
                }
                i++;
                if(i>= num.length){
                    break;
                }


            }
            if (opr.length == 0) {
                a += Integer.parseInt(num[0]);
            }

        }catch (Exception e){
            int y=0;
        }

        return a;
    }
    private static double doMath(String query){
        String[] num = query.split("[+-/*()]");
        String[] opr= query.split("[0-9]");
        double a=Integer.parseInt(num[0]);
        int i=1;

        try{
            for (String s : opr) {
                System.out.println(num[i]);
                if(s.equals("")){
                    continue;
                }
                int b;
                if(i<=num.length){
                     b = Integer.parseInt(num[i]);
                }else{
                    break;
                }
                if (s.equals("+")) {
                    a += b;
                } else if (s.equals("-")) {
                    a -= b;
                } else if (s.equals("/") && b != 0) {
                    if (i == 0) {
                        a = 1;
                    }
                    a /= b;
                }
                else {
                    if (i == 0) {
                        a = 1;
                    }
                    a *= b;
                }
                i++;

            }
            if (opr.length == 0) {
                a += Integer.parseInt(num[0]);
            }


        }catch (Exception e){
            int y=0;
        }

        return a;
    }
    public static boolean isValid(String s) {

        Stack<Character> stackOb = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {
                stackOb.push(c);
            }

            else if (c == ')' && !stackOb.isEmpty() && stackOb.peek() == '(') {
                stackOb.pop();
            } else if (c == '}' && !stackOb.isEmpty() && stackOb.peek() == '{') {
                stackOb.pop();
            } else if (c == ']' && !stackOb.isEmpty() && stackOb.peek() == '[') {
                stackOb.pop();
            }

            else {
                return false;
            }
        }
        return stackOb.isEmpty();
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        while(true){
            System.out.print("Enter your Query : ");
            String query = userInput.nextLine();
            boolean plus = query.contains("+");
            boolean minus = query.contains("-");
            boolean star = query.contains("*");
            boolean slash = query.contains("/");
            if ((plus && star) || (plus && slash) || (minus && star) || (minus && slash)) {
                if(query.contains("(")){
                    if (!isValid(query)) {
                        System.out.println(doMathsWithBraces(query));
                    } else {
                        System.out.println("Invalid input");
                    }
                }
                else{
                    System.out.println("Invalid input use braces");
                }

            }
            else {
                System.out.println(doMath(query));
            }
        }
    }
}
