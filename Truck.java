public class Truck extends Vehicle {
    protected double loadCapacity;
    protected boolean hasCoolingSystem;
    public Truck(int plateNumber, String company, String model, double dayleyCost, double loadCapacity, boolean hasCoolingSystem) {
        super(plateNumber, company, model, dayleyCost);
        this.loadCapacity = loadCapacity;
        this.hasCoolingSystem = hasCoolingSystem;
            if(hasCoolingSystem){
                this.rate = 0.05;
    }
}

    @Override
    public String displayInfo() {
        super.displayInfo();
        Info+="Load Capacity: " + loadCapacity + "\nHas Cooling System: " + ((hasCoolingSystem) ? "Yes" : "No");
        Info+="\n=======================================================";  
        return Info;
    }
    
}
