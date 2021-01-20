package assignment1;

/**
 * The CommercialClient program implements an application that
 * simply inherits from class Client
 * and gives a default values to information of Commercial client
 * @return String this returns all information of Commercial client
 */
class CommercialClient extends Client {
    private String commercialID;
    private String NationalID;

    /**
     * This method is used to give dafult values of Comerical client
     * (commercial id,national id) This is
     * a the simplest form of a class method, just to
     * show the usage of various javadoc Tags.
     * @param account this is the object from class Account
     */
    public CommercialClient(Account account){
        super(account);
        this.commercialID="";
        this.NationalID="";
    }
    /**
     * Sets the CommerciallId.
     * @param c A String containing the commercial_id .
     */
    public void setCommercialID(String c){
        this.commercialID=c;
    }
    /**
     * Sets the NationalId.
     * @param n A String containing the National_id .
     */
    public void setNationalID(String n){
        this.NationalID=n;
    }
    /**
     * Gets the CommerciallId.
     * @return A string representing the commercial_id.
     */
    public String getCommercialID(){
        return commercialID;
    }
    /**
     * Gets the NathionalId.
     * @return A string representing the National_id.
     */
    public String getNationalID(){
        return NationalID;
    }

    /**
     *This method is used to return objects as String
     *this is a method in java This is
     * a the simplest form of a class method, just to
     * show the usage of various javadoc Tags.
     */
    @Override
    public String toString() {
        return "CommercialClient:" +
                "name:'" + getName() + '\n' +
                "commercial_id:'" + getCommercialID() + '\n' +
                "address:'" + getAddress() + '\n' +
                "phone:'" + getPhone() + '\n' +
                getAccount().toString();
    }
}
