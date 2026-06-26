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
    if(engineCapacity>500 && !hasSideSeat){
        this.rate = 0.04;
    }
}
    @Override
    public String displayInfo() {
        super.displayInfo();
        Info+=" Engine Capacity: " + engineCapacity + "\nHas Side Seat: " + ((hasSideSeat) ? "Yes" : "No");
        Info+="\n=======================================================";  
        return Info;
    
    }
}
