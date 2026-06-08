import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class Contract {
    public  Client client;
    public Vehicle Vehicle;
    public LocalDate startDate;
    public int durationInDays;
    public int lateDays;
    public double totalCost=0;
    public boolean isClosed=false;
        Contract(Client Client_name, Vehicle Vehicle, LocalDate startDate, int durationInDays) {
            this.client = Client_name;
            this.Vehicle = Vehicle;
            this.startDate = startDate;
            this.durationInDays = durationInDays;
        }
        public void displayInfo(){
            System.out.println("=======================================================");  
            System.out.println("Client Name: "+client.name);
            System.out.println("Vehicle Plate Number: "+Vehicle.plateNumber);
            System.out.println("Start Date: "+startDate.getDayOfMonth()+"/"+startDate.getMonthValue()+"/"+startDate.getYear());
            System.out.println("Duration in Days: "+durationInDays);
            if(ChronoUnit.DAYS.between(startDate, LocalDate.now())>durationInDays){
                System.out.println("The contract is late by "+lateDays+" days.");
            }else{
                System.out.println("There are "+(durationInDays - ChronoUnit.DAYS.between(startDate, LocalDate.now()))+" days left until the contract is due.");
            }
            System.out.println("Is Closed: "+(isClosed? "yes":"No"));
            if(isClosed){
                System.out.println("Total Cost: "+totalCost);
            }
            System.out.println("=======================================================");  
        }
        public void lateness(){
             long daysBetween = ChronoUnit.DAYS.between(startDate, LocalDate.now());
             lateDays = (int) daysBetween - durationInDays;
             lateDays = Math.max(lateDays,0);

        }
        public double calculateFine(){
            totalCost=0;
         lateness();
         client.isVip();
         totalCost+= durationInDays * Vehicle.dayleyCost;
         totalCost+= totalCost * Vehicle.rate;
         totalCost-= totalCost * client.rate;
         totalCost+=0.1*lateDays*totalCost;
         return totalCost;
        }



}
