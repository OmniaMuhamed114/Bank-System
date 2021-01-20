package assignment1;

/**the account class implements an application that withdraw and deposit in this account
 */

public class Account {
    private int accountNumber;
    private double balance;

    /**
     * this is default constructor for this class to set values to account and accountnumber
     */

    Account() {
        balance =0.0;
        accountNumber =-1;
    }

    /**
     * this method set the value to accountNumber
     * @param num to set it in accountNumber
     * @return nothing
     */

    public void setAccountNumber(int num) {
        this.accountNumber = num;
    }

    /**
     * this method get the value of accountNumber
     * @return int This return accountNumber
     */

    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * this method set the value to balance
     * @param B to set it in balance
     * @return nothing
     */

    public void setBalance(double B) {
        this.balance = B;
    }

    /**
     *
     * this method get the value of balance
     * @return double this return balance
     */

    public double getBalance() {
        return balance;
    }

    /**
     * this method deposite in account
     * @param value1 to add it in account balance
     * @return double this return balance
     */


    public double deposit(double value1)
    {
        balance = balance + value1;
        return balance;
    }

    /**
     * this method withdraw in account
     * @param value1 to withdraw it from account
     * @return double this return balance
     */

    public double withdraw(double value1)
    {
        if(balance < value1){
            System.out.println("Insufficient Funds");
        }else{
            System.out.println("successful withdraw");
            balance -= value1;
        }
        return balance;
    }

    /**
     * this method returns the string representation of the the account information
     */

    @Override
    public String toString() {
        return "Account:" + '\n' +
                "Account number:" + accountNumber + '\n' +
                "Balance:" + balance + '\n';
    }
}