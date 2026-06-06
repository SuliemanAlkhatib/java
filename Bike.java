public class Bike extends Vehicle {
    protected double engineCapacity;
    protected boolean hasSideSeat;
    public Bike(int plateNumber, String company, String model, double dayleyCost, double engineCapacity, boolean hasSideSeat) {
        super(plateNumber, company, model, dayleyCost);
        this.engineCapacity = engineCapacity;
        this.hasSideSeat = hasSideSeat;
        if(hasSideSeat){
            this.rate = 0.02;
    }
}
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Engine Capacity: " + engineCapacity + "\nHas Side Seat: " + ((hasSideSeat) ? "Yes" : "No"));
    
    }
}
