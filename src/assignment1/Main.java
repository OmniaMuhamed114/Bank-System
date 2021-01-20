package assignment1;

import java.io.IOException;
import java.util.ArrayList;                                          //Omnia Mohamed Elsayed Naeem  20180056 G3
import java.util.Scanner;                                            //Malak Rizk Hanafi Ahmed  20180288  G3
                                                                     //Salma Ahmed Hisham moustafa   20180123  G3
public class Main {
    /**
     * This is the main method which makes use of createClient,
     * createCommercialClient,accountControl,mainMenu,
     * searchingAccount,getIntFromUser,getDoubleFromUser,
     * getStringFromUser,getStringNumFromUser and getStringAlphaFromUser
     * methods.
     * @param args Unused.
     * @return Nothing.
     * @exception IOException On input error.
     */
    public static void main(String[] args) {
        mainMenu();
    }
    /**
     * This method is used to create client or commercial client
     * display two type of account general or special
     * to the standard output.
     * check if input inhaled or not
     * enter all information(name,national id,address,phone,commercial ID,National ID)
     * Print the client's(name,address,
     * national id,phone,,commercial ID,National ID,account number,balance) on the screen
     * @param bank this is an object from class Bank
     * @return String this return information of client
     */
    private static Client createClient(Bank bank, boolean isSpecial, boolean isCommercial){
        Account account = isSpecial ? new SpecialAccount() : new Account();
        Client client = isCommercial ? new CommercialClient(account) : new Client(account);
        int num = bank.createAccountNum();
        account.setAccountNumber(num);
        System.out.println("please enter the name:");
        String name=getStringAlphaFromUser();
        client.setName(name);
        if(isCommercial){
            System.out.println("please enter the commercial ID:");
            String commercialID= getStringNumFromUser();
            ((CommercialClient) client).setCommercialID(commercialID);
        }else{
            int count =0;
            while(count<14){
            System.out.println("please enter the National ID:");
            String NationalID=getStringNumFromUser();
            for(int i = 0; i < NationalID.length(); i++) {
                if(NationalID.charAt(i) != ' ')
                    count++;
            }
            if (count<14){
                System.out.println("invalid National id");
            }
            client.setNationalId(NationalID);
            }
        }
        System.out.println("please enter the address:");
        String address=getStringFromUser();
        client.setAddress(address);
        System.out.println("please enter the phone:");
        String phone=getStringNumFromUser();
        client.setPhone(phone);
        System.out.println(client);
        return client;
    }
    /**
     * This method is used to control account
     * display options that client may want to do
     * check if input invalid or not
     * @param account this is an object from class Account.
     * @return Nothing.
     */
    private static void accountControl(Account account){
        do {
            System.out.println("please choose from these options:");
            System.out.println("1- deposit Amount:");
            System.out.println("2- withdraw Amount:");
            System.out.println("3- show the balance:");
            System.out.println("4- main menu:");
            int choice=getIntFromUser(1,4);
            switch(choice){
                case 1:
                    System.out.println("please enter your the Amount you want to deposit:");
                    double value1=getDoubleFromUser();
                    account.deposit(value1);
                    System.out.println("the Amount was deposited");
                    System.out.println("Your balance is: "+account.getBalance());
                    break;
                case 2:
                    System.out.println("please enter your the value you want to withdraw:");
                    double value2=getDoubleFromUser();
                    account.withdraw(value2);
                    System.out.println("Your balance is: " +account.getBalance());
                    break;
                case 3:
                    System.out.println("the balance:"+account.getBalance()+'\n');
                    break;
                default:
                    return;
            }
        }while (true);
    }
    /**
     * This method is used to show main menu whose
     * all option available in this program.
     * if user choice first option will
     * have anther menu to choice personal or
     * commercial client.
     * @return Nothing.
     */
    public static void mainMenu(){
        Bank bank=new Bank();
        String name="Egypt Bank";
        String address="9 El Aresh street";
        String phone="01156735748";
        bank.setName(name);
        bank.setAddress(address);
        bank.setPhone(phone);
        System.out.println("Welcome to "+bank.getName());
        System.out.println("Our address is "+bank.getAddress());
        System.out.println("Our phone is "+bank.getPhone());
        boolean anotherChoice = true;
        int numberOfAccounts=0;
        do{
            System.out.println("please choose from these options:");
            System.out.println("1- Add new Account");
            System.out.println("2- Manage account");
            System.out.println("3- Show all clients and their accounts");
            System.out.println("4- End the program");
            int choice=getIntFromUser(1,4);
            switch(choice){
                case 1:
                    System.out.println("which kind of client do you want:");
                    System.out.println("1- personal client");
                    System.out.println("2- Commercial client");
                    int clientType = getIntFromUser(1,2);
                    System.out.println("1- general Account");
                    System.out.println("2- special Account");
                    int accountType=getIntFromUser(1,2);
                    Client newClient = createClient(bank, accountType == 2, clientType == 2);
                    bank.addNewClient(newClient);
                    numberOfAccounts+=1;
                    System.out.println("account created");
                    accountControl(newClient.getAccount());
                    break;
                case 2:
                    if (numberOfAccounts==0){
                        System.out.println("no clients exist");
                    }
                    else{
                        System.out.println("please enter the account number:");
                        Account acc = searchForAccount(bank);
                        if(acc == null){
                            System.out.println("no account found with this number");
                        }else{
                            System.out.println(acc);
                            accountControl(acc);
                        }
                    }
                    break;
                case 3:
                    if (numberOfAccounts==0){
                        System.out.println("no clients exist");
                    }
                    else{
                        bank.printAllClients();
                    }
                    break;
                default:
                    System.out.println("Thanks!");
                    System.exit(0);
                    break;
            }
            String choice2 = null;
            System.out.println("Do you want another service?");
            boolean error;
            do{
                error = false;
                choice2=getStringAlphaFromUser();
                if(choice2.toLowerCase().equals("yes")){
                    anotherChoice=true;
                }
                else if(choice2.toLowerCase().equals("no")){
                    anotherChoice=false;
                }
                else{
                    System.out.println("invalid choice");
                    error = true;
                }
            }while (error);
        }while(anotherChoice);
    }
    /**
     * This method is used to search for account
     * using account number.
     * @param bank this is the parameter to searchingAccount method.
     * @return Nothing.
     */
    public static Account searchForAccount(Bank bank){
        int acc=getIntFromUser();
        ArrayList<Account> accounts = bank.getAccounts();
        for(Account a: accounts){
            if(a.getAccountNumber() == acc){
                return a;
            }
        }
        return null;
    }
    /**
     *This method is used to check if input
     * intger or not.
     */
    private static int getIntFromUser(){
        Scanner s = new Scanner(System.in);
        do {
            while (!s.hasNextInt()) {
                System.out.println("Please enter valid number");
                s.next();
            }
            return s.nextInt();
        }while (true);
    }
    /**
     * This method is used to check if input
     * integr or not but there limet to begain
     * and limet to end.
     * @param from this is the first parameter to getIntFromUser method.
     * @param to this is the second parameter to getIntFromUser method.
     */
    private static int getIntFromUser(int from, int to){
        Scanner s = new Scanner(System.in);
        do {
            while(!s.hasNextInt()){
                System.out.println("Please enter valid number");
                s.next();
            }
            int input = s.nextInt();
            if(input >= from && input <= to){
                return input;
            }else{
                System.out.println("Please enter valid number");
            }
        }while (true);
    }
    /**
     * This method is used to check if input
     * double or not.
     * @return double this returns input that user enter.
     */
    private static double getDoubleFromUser(){
        Scanner s = new Scanner(System.in);
        while(!s.hasNextDouble()) {
            System.out.println("Please enter valid number");
            s.next();
        }
        double input = s.nextDouble();
        return input;
    }

    /**
     * This method is used to check if input
     * string or not.
     * @return Sring this returns input that user enter.
     */
    private static String getStringFromUser(){
        Scanner s = new Scanner(System.in);
        do {
            String input = s.nextLine();
            if(input == null || input.isEmpty()){
                System.out.println("Please enter valid string");
            }else{
                return input;
            }
        }while (true);

    }
    /**
     * This method is used to check if input
     * string or not and accept only numbers.
     *@return String this input that user enter.
     */

    private static String getStringNumFromUser(){
        Scanner s = new Scanner(System.in);
        do {
            String input = s.nextLine();
            if(input == null || input.isEmpty()){
                System.out.println("Please enter valid string");
            }
            else if(!input.matches("[0-9]+")){
                System.out.println("Please enter valid string");
            }
            else{
                return input;
            }
        }while (true);
    }
    /**
     * This method is used to check if input
     * string or not and accept only alphabet and spaces.
     *@return String this input that user enter.
     */
    private static String getStringAlphaFromUser(){
        Scanner s = new Scanner(System.in);
        do {
            String input = s.nextLine();
            if(input == null || input.isEmpty()){
                System.out.println("Please enter valid string");
            }
            else if(!input.matches("[a-zA-Z' ']+")){
                System.out.println("Please enter valid string");
            }
            else{
                return input;
            }
        }while (true);
    }
}