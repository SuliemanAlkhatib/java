public class Car extends Vehicle {
    protected String gasType;
    protected int numberOfSeats;
    public Car(int plateNumber, String company, String model, double dayleyCost, String gasType, int numberOfSeats) {
        super(plateNumber, company, model, dayleyCost);
        this.gasType = gasType;
        this.numberOfSeats = numberOfSeats;
        if("Electric".equals(gasType)){
            this.rate = 0.05;
        }
        if(numberOfSeats>5&&!"Electric".equals(gasType)){
            this.rate = 0.1;
        }
    }
    @Override
    public String displayInfo() {
        super.displayInfo();
        Info+="Gas Type: " + gasType + "\nNumber Of Seats: " + numberOfSeats ;
        Info+="\n=======================================================";  
        return Info;
    }
    public String toString(){
        return "company name: "+company +"\nrate: "+rate+"\n car model "+ model +"\n plate number "+plateNumber+"\n dayley Cost "+dayleyCost+"\n isAvailable "+((isAvailable)?"Yes":"NO"+" Gas Type: " + gasType + "\nNumber Of Seats: " + numberOfSeats+"\n==================================\n");
     }
}
