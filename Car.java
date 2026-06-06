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
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Gas Type: " + gasType + "\nNumber Of Seats: " + numberOfSeats );
    }

}
