package assignment1;

/*
 * this class inherits from class Account
 * it uses polymorphism to override method withdraw
 */

class SpecialAccount extends Account {

    /**
     * this method withdraw in account and allow over drafting with maximum limit of 1000 LE
     * @param value to add it in account after it checks the value
     * @return double this return balance
     */

    @Override
    public double withdraw(double value) {
        double balance = getBalance();
        if (balance - value >= -1000) {
            balance = balance - value;
            setBalance(balance);
        } else {
            System.out.println("you can not withdraw from this account");
        }
        return balance;
    }
}