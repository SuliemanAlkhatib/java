public class Corporate extends Client {
    protected String taxNumber;
    protected double rate;
    Corporate( String name, String phoneNumber, String Address, String taxNumber, double rate) {
        super( name, phoneNumber, Address);
        this.taxNumber = taxNumber;
        this.rate = rate;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Tax Number: "+taxNumber);
        System.out.println("Rate: "+rate);
    }
}
