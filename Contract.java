import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class Contract {
    public  Client client;
    public Vehicle Vehicle;
    public LocalDate startDate;
    public int durationInDays;
    public int lateDays;
    public double fine=0;
    public boolean isClosed=false;
        Contract(Client Client_name, Vehicle Vehicle, LocalDate startDate, int durationInDays) {
            this.client = Client_name;
            this.Vehicle = Vehicle;
            this.startDate = startDate;
            this.durationInDays = durationInDays;
        }
        public void displayInfo(){
            System.out.println("Client Name: "+client.name);
            System.out.println("Vehicle Plate Number: "+Vehicle.plateNumber);
            System.out.println("Start Date: "+startDate.getDayOfMonth()+"/"+startDate.getMonthValue()+"/"+startDate.getYear());
            System.out.println("Duration in Days: "+durationInDays);
            System.out.println("Is Closed: "+(isClosed? "yes":"No"));
        }
        public void lateness(){
             long daysBetween = ChronoUnit.DAYS.between(startDate, LocalDate.now());
             lateDays = (int) daysBetween - durationInDays;
             lateDays = Math.max(lateDays,0);

        }
        public double calculateFine(){
            if(client instanceof Person p){
                p.isVip();
            }
         lateness();
         fine+= durationInDays * Vehicle.dayleyCost;
         fine+= fine * Vehicle.rate;
         fine-= fine * client.rate;
         fine+=0.1*lateDays*fine;
         return fine;
        }



}
