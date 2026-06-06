abstract public class Client  {
    protected String name;
    protected String phoneNumber;
    static int counter=0;
    protected final int id;
    protected String Address;
    protected double rate=0.0;
    public Client( String name, String phoneNumber, String Address) {
        this.id=counter++;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.Address = Address;
    }

    public void displayInfo(){
        System.out.println("ID: "+id);
        System.out.println("Name: "+name);
        System.out.println("Phone Number: "+phoneNumber);
        System.out.println("Address: "+Address);
    }                   
}
