package Assignment6;

import java.util.Scanner;

public class Atm {

    private int availableAmountInMachine;
    private int transactionFee;
    private UserData userData;

    public Atm(int availableAmountInMachine, int transactionFee){
        this.availableAmountInMachine = availableAmountInMachine;
        this.transactionFee = transactionFee;
        userData = new UserData();
    }

    public void start(){
        System.out.println("Please Enter 'NEW USER' or 'CURRENT USER'");
        Scanner s = new Scanner(System.in);
        if(s.nextLine().equals("NEW USER")){
            createNewUser();
        } else if(s.nextLine().equals("CURRENT USER")){
            login();
        } else {
            throw new IllegalArgumentException("Please Enter Valid Information");
        }
    }

    public void createNewUser(){
        Scanner s = new Scanner(System.in);
        User newUser = new User();
        System.out.println("Please Enter Your Name");
        newUser.setName(s.nextLine());
        System.out.println("Please Enter Your Age");
        if(s.hasNextInt()){
            newUser.setAge(s.nextInt());
            s.nextLine();
        } else {
            throw new IllegalArgumentException("Please Enter Valid Information");
        }
        System.out.println("Please Enter Your Address");
        newUser.setAddress(s.nextLine());
        System.out.println("Please Enter Your Phone Number");
        if(s.hasNextLong()){
            newUser.setPhoneNumber(s.nextLong());
            s.nextLine();
        } else {
            throw new IllegalArgumentException("Please Enter Valid Information");
        }
        int backAccount = userData.getUserSize() + 1;
        newUser.setBankAccountNumber(backAccount);
        System.out.println("Your Bank Account Number is " + newUser.getBankAccountNumber());
        System.out.println("Please Enter Your 6-digit Password");
        if(s.hasNextInt()){
            if(s.nextInt() < 1000000 && s.nextInt() > 99999){
                userData.addUser(newUser, s.nextInt());
                s.nextLine();
            } else {
                throw new IllegalArgumentException("Please Enter Valid Password");
            }
        } else {
            throw new IllegalArgumentException("Please Enter Valid Password");
        }
        System.out.println("Please Enter 'LOGIN' or 'RETURN' or 'EXIT'");
        if(s.nextLine().equals("LOGIN")){
            login();
        } else if(s.nextLine().equals("RETURN")){
            start();
        } else if(s.nextLine().equals("EXIT")){
            return;
        } else {
            throw new IllegalArgumentException("Please Enter Valid Information");
        }
    }

    public void login(){
        System.out.println("Please Enter Your Bank Account Number");
        Scanner s = new Scanner(System.in);
        if(s.hasNextInt()){
            int bankAccountNumber = s.nextInt();
            s.nextLine();
            User current = (User)userData.accountToUser.get(bankAccountNumber);
            if(userData.loginData.containsKey(bankAccountNumber)){
                System.out.println("Please Enter Your Password or 'FORGET PASSWORD'");
                if(s.hasNextInt()){
                    if(s.nextInt() == (int)userData.loginData.get(bankAccountNumber)){
                        System.out.println("Please Enter 'AVAILABLE BALANCE' or 'WITHDRAWAL' or 'DEPOSIT' or 'RECENT TRANSACTIONS' or 'CHANGE PASSWORD' or 'RETURN' or 'EXIT'");
                        if(s.nextLine().equals("CHANGE PASSWORD")){
                            System.out.println("Please Enter New 6-digit Password");
                            if(s.hasNextInt()){
                                if(s.nextInt() < 1000000 && s.nextInt() > 99999){
                                    userData.loginData.put(bankAccountNumber, s.nextInt());
                                    s.nextLine();
                                } else {
                                    throw new IllegalArgumentException("Please Enter Valid Password");
                                }
                            } else {
                                throw new IllegalArgumentException("Please Enter Valid Password");
                            }
                        } else if(s.nextLine().equals("AVAILABLE BALANCE")){
                            current.getAvailableBalance();
                        } else if(s.nextLine().equals("WITHDRAWAL")){
                            System.out.println("Please Enter Amount");
                            if(s.hasNextInt()){
                                if(s.nextInt() <= availableAmountInMachine && s.nextInt() >= 0){
                                    availableAmountInMachine = availableAmountInMachine - s.nextInt();
                                    current.setAvailableBalance(current.getAvailableBalance() - s.nextInt() - transactionFee);
                                    current.addRecentTransactions("\nWITHDRAWAL: " + s.nextInt());
                                    s.nextLine();
                                } else if(s.nextInt() < 0){
                                    throw new IllegalArgumentException("Please Enter Valid Amount");
                                } else {
                                    throw new IllegalArgumentException("No Enough Money in Machine");
                                }
                            } else {
                                throw new IllegalArgumentException("Please Enter Valid Amount");
                            }
                        } else if(s.nextLine().equals("DEPOSIT")){
                            System.out.println("Please Enter Amount");
                            if(s.hasNextInt()){
                                if(s.nextInt() >= 0){
                                    availableAmountInMachine = availableAmountInMachine + s.nextInt();
                                    current.setAvailableBalance(current.getAvailableBalance() + s.nextInt() - transactionFee);
                                    current.addRecentTransactions("\nDEPOSIT: " + s.nextInt());
                                    s.nextLine();
                                } else {
                                    throw new IllegalArgumentException("Please Enter Valid Amount");
                                }
                            } else {
                                throw new IllegalArgumentException("Please Enter Valid Amount");
                            }
                        } else if(s.nextLine().equals("RECENT TRANSACTION")){
                            System.out.println(current.getRecentTransactions());
                        } else if(s.nextLine().equals("EXIT")){
                            return;
                        } else {
                            throw new IllegalArgumentException("Please Enter Valid Information");
                        }
                    } else {
                        if(s.nextLine().equals("FORGET PASSWORD")){
                            System.out.println("Please Enter Your Name");
                            if(!s.nextLine().equals(current.getName())){
                                throw new IllegalArgumentException("Wrong Name");
                            }
                            System.out.println("Please Enter Your Age");
                            if(s.nextInt() != (current.getAge())){
                                throw new IllegalArgumentException("Wrong Age");
                            }
                            System.out.println("Please Enter Your Phone Number");
                            if(s.nextLong() != (current.getPhoneNumber())){
                                throw new IllegalArgumentException("Wrong Phone Number");
                            }
                            System.out.println("Please Enter New 6-digit Password");
                            if(s.hasNextInt()){
                                if(s.nextInt() < 1000000 && s.nextInt() > 99999){
                                    userData.loginData.put(bankAccountNumber, s.nextInt());
                                    s.nextLine();
                                } else {
                                    throw new IllegalArgumentException("Please Enter Valid Password");
                                }
                            } else {
                                throw new IllegalArgumentException("Please Enter Valid Password");
                            }
                        } else{
                            throw new IllegalArgumentException("Please Enter Valid Information");
                        }
                    }
                } else {
                    throw new IllegalArgumentException("Please Enter Valid Password");
                }
            } else {
                throw new IllegalArgumentException("Please Enter Valid Bank Account Number");
            }
        } else {
            throw new IllegalArgumentException("Please Enter Valid Bank Account Number");
        }
    }


}
