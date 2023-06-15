package com.bank;

import java.util.HashMap;
import java.util.Scanner;


public class Main extends Exception {


    public static void accInfo(int accNo, int pin){
        int bal=10_000;
        System.out.println("Type 1 -> Balance enquiry\nType 2 -> Withdraw\nType 3 -> Change Pin\nType 4 -> Exit");
        Scanner UserInput = new Scanner(System.in);
        int res = UserInput.nextInt();
        if(res==1){
            System.out.println("Balance : "+bal);
        }else if(res==2){
            System.out.print("Enter amount : ");
            int amt = UserInput.nextInt();
            bal-=amt;
        }
        else if(res==4){
            return;
        }
        else {
            System.out.println("This service is currently unavailable kindly visit your branch");
        }
        accInfo(accNo,pin);

    }
    public static void main(String[] args) {

        HashMap<Integer, Integer> Acc_no = new HashMap<>();
        Acc_no.put(7847, 9844);
        Scanner UserInput = new Scanner(System.in);
        String inPut ="";
        int x=1;
        while(x!=0){
            try {
                System.out.print("Enter Account Number : ");
                int accNo = UserInput.nextInt();
                if(Acc_no.containsKey(accNo)){
                    System.out.print("\nEnter Pin : ");
                    int pin = UserInput.nextInt();
                    if(pin==Acc_no.get(accNo)){
                        accInfo(accNo,pin);
                        x=0;
                        break;
                    }

                }
                System.out.println("Invalid Username or Password");
                continue;
            } catch (Exception e) {
                System.out.println("Invalid input");
                break;
            }

        }


    }
}
