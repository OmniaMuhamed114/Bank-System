package assignment1;

import java.util.ArrayList;

/**
 *The bank program implements an application that
 *simply Adds new client
 *and shows information about exiting client and his account
 *and greats account number for client
 */
public class Bank {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Account> accounts;
    private ArrayList<Client> clients;
    public Bank() {
        name="";
        address="";
        phone="";
        accounts = new ArrayList<>();
        clients = new ArrayList<>();
    }
    /**
     * Gets the name.
     * @return A string representing the name.
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the name.
     * @param name A String containing the name.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Gets the address.
     * @return A string representing the address.
     */
    public String getAddress() {
        return address;
    }
    /**
     * Sets the address.
     * @param address A String containing the address.
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * Gets the phone.
     * @return A string representing the phone.
     */
    public String getPhone() {
        return phone;
    }
    /**
     * Sets the phone.
     * @param phone A String containing the phone.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
     *This method is used to add new client
     *and add account for this client This is
     * a the simplest form of a class method, just to
     * show the usage of various javadoc Tags.
     * @parem object from class client
     */
    public void addNewClient(Client client){
        clients.add(client);
        accounts.add(client.getAccount());
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }
    /**
     *This method is used to print information about
     * all exiting clients and their accounts This is
     * a the simplest form of a class method, just to
     * show the usage of various javadoc Tags.
     */
    public void printAllClients(){
        for (Client client : clients) {
            System.out.println(client);
        }
    }
    /**
     *This method is used to generate account number randomly
     * and check if the random account number is already
     * used or not This is
     * a the simplest form of a class method, just to
     * show the usage of various javadoc Tags.
     */
    public int createAccountNum(){
        int accountNumber;
        boolean error;
        do{
            accountNumber = (int)((Math.random() * 9000)+1000);
            error = false;
            for(Account acc: accounts){
                if(acc.getAccountNumber() == accountNumber){
                    error = true;
                    break;
                }
            }
        }while (error);
        return accountNumber;
    }
}