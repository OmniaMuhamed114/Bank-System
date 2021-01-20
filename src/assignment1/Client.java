package assignment1;

/**
 * The Client program implements an application that
 * simply gives a default values to information of client
 * @return String this returns all information of client
 */
public class Client {
    private String name;
    private String national_id;
    private String address;
    private String phone;
    private Account account;

    public Client() {
    }

    /**
     * This method is used to give dafult values of client
     * (name,national id,address,phone) This is
     * a the simplest form of a class method, just to
     * show the usage of various javadoc Tags.
     * @param account this is the object from class Account
     */
    public Client(Account account){
        this.name = "";
        this.national_id = "";
        this.address = "";
        this.phone= "";
        this.account = account;
    }
    /**
     * Sets the name.
     * @param n A String containing name.
     */
    public void setName(String n){
        this.name=n;
    }
    /**
     * Sets the NationalId.
     * @param id A String containing the national_id .
     */
    public void setNationalId(String id){
        this.national_id=id;
    }
    /**
     * Sets the address.
     * @param a A String containing the address.
     */
    public void setAddress(String a){
        this.address=a;
    }
    /**
     * Sets the phone.
     * @param p A String containing the phone.
     */
    public void setPhone(String p){
        this.phone=p;
    }
    /**
     * Gets the name.
     * @return A string representing the name.
     */
    public String getName(){
        return name;
    }
    /**
     * Gets the NathionalId.
     * @return A string representing the national_id.
     */
    public String getNationalId(){
        return national_id;
    }
    /**
     * Gets the address.
     * @return A string representing the address.
     */
    public String getAddress(){
        return address;
    }
    /**
     * Gets the phone.
     * @return A string representing the phone.
     */

    public String getPhone(){
        return phone;
    }
    /**
     * Gets the account.
     * @return A string representing the account , that an objct from type Account.
     */
    public Account getAccount() {
        return account;
    }

    /**
     *This method is used to return objects as String
     *this is a method in java This is
     * a the simplest form of a class method, just to
     * show the usage of various javadoc Tags.
     */
    @Override
    public String toString() {
        return "Client:" + '\n' +
                "name:'" + name + '\n' +
                "national_id:'" + national_id + '\n' +
                "address:'" + address + '\n' +
                "phone:'" + phone + '\n' +
                account.toString();
    }
}
