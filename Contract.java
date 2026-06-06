import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class Contract {
    public  Client client;
    public Vehicle Vehicle;
    public LocalDate startDate;
    public int durationInDays;
    public int lateDays;
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
        }
        public void lateness(){
             long daysBetween = ChronoUnit.DAYS.between(startDate, LocalDate.now());
             lateDays = (int) daysBetween - durationInDays;

        }
        public double calculateFine(){
         lateness();
         double fine =0;
         fine+= durationInDays * Vehicle.dayleyCost;
         fine+= fine * Vehicle.rate;
         fine-= fine * client.rate;
         return fine;
        }



}
