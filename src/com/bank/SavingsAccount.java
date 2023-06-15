package com.bank;

import java.util.HashMap;
import java.util.Scanner;

public class SavingsAccount {

    private static void accInfo(int accNo, int pin, HashMap accInfo, int bal){
        System.out.println("Savings Account : ");
        while(true){
            System.out.println("Type 1 -> Balance enquiry\nType 2 -> Withdraw\nType 3 -> Deposit\nType 4 -> Change pin\nType 0 -> Exit");
            Scanner UserInput = new Scanner(System.in);
            int res = UserInput.nextInt();
            if (res == 1) {
                System.out.println("Balance : " + bal);
            } else if (res == 2) {
                System.out.print("Enter amount : ");
                int amt = UserInput.nextInt();
                if(amt>10 && amt<=bal && amt<=10_000){
                    bal -= amt;
                    System.out.println("Kindly take your cash and visit again...\nThank you...");
                }
                else if(amt>bal){
                    System.out.println("Insufficient balance");
                }
                else{
                    System.out.println("Enter an amount between 10 - 10,000");
                }
            } else if (res == 3) {
                System.out.print("Enter amount : ");
                int depositAmt = UserInput.nextInt();
                if(depositAmt>10 && depositAmt<=10_000){
                    bal+=depositAmt;
                    System.out.println("Ampount de[posited successfully");
                    System.out.println("Balance : "+ bal);
                }
                else{
                    System.out.println("Enter an amount between 10 - 10,000");
                }
            } else if(res==4) {
                System.out.println("Verify your number");
                System.out.print("Enter OTP : ");
                int OTP = (int) (Math.random() * 1_000_000);
                System.out.println(OTP);
                int otp = UserInput.nextInt();

                if (otp == OTP) {
                    System.out.println("User verified");
                    System.out.println("Enter your new pin : ");
                    int newPin = UserInput.nextInt();
                    accInfo.put(accNo, newPin);
                    System.out.println(accInfo);
                } else {
                    System.out.println("Incorrect otp");
                    System.out.println("Process terminated");
                }
            }
            else{
                return;
            }
        }


    }
    static void getSavingsAccount(int accNo, int pin, HashMap accInfo){
        int bal=0;
        accInfo(accNo, pin, accInfo, 0);
    }
}
