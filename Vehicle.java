abstract public class Vehicle {
    public int rentCount =0;
    protected int plateNumber;
    protected String company;
    protected double rate;
    protected String model;
    protected double dayleyCost;
    protected boolean isAvailable;
    public Vehicle(int plateNumber, String company, String model, double dayleyCost) {
        this.plateNumber = plateNumber;
        this.company = company;
        this.model = model;
        this.dayleyCost = dayleyCost;
        this.isAvailable = true;
    }

     public void displayInfo(){
        System.out.println("company name: "+company +"\nrate: "+rate+"\n car model "+ model +"\n plate number "+plateNumber+"\n dayley Cost "+dayleyCost+"\n isAvailable "+((isAvailable)?"Yes":"NO"));
     }
}
