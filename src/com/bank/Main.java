package com.bank;

import java.util.HashMap;
import java.util.Scanner;


public class Main extends Exception {



    public static void main(String[] args) {

        HashMap<Integer, Integer> Acc_no = new HashMap<>();
        Acc_no.put(7847, 9844);
        Scanner UserInput = new Scanner(System.in);
        while(true){
            try {
                System.out.println("Welcome to Terzo banking and Finance, ");
                System.out.print("Enter Account Number : ");
                int accNo = UserInput.nextInt();
                if(Acc_no.containsKey(accNo)){
                    System.out.print("\nEnter Pin : ");
                    int pin = UserInput.nextInt();
                    if(pin==Acc_no.get(accNo)){
                        getAccInfo(accNo,pin, Acc_no);
                        continue;
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
    public static void getAccInfo(int accNo, int pin, HashMap accInfo){
        Scanner userInput = new Scanner(System.in);

            System.out.println("Choose Account Type : ");
            System.out.println("Type 1 -> Current Account\nType 2 -> Savings Account\nType 0 -> Exit");
            int choice = userInput.nextInt();
            if(choice==1){
                CurrentAccount.getCurrentAccount(accNo, pin, accInfo);
            }
            else if(choice==2){
                SavingsAccount.getSavingsAccount(accNo, pin, accInfo);
            }else if(choice==0){
                return;
            }
            else{
                System.out.println("Invalid input");
            }


    }


}
