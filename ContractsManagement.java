import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
public class ContractsManagement {
    public static void addContract(ArrayList<Contract> contracts, ArrayList<Client> clients, ArrayList<Vehicle> vehicles){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Client name: ");
        String clientname = sc.next();
        Client client = null;
        for(Client c : clients){
            if(c.name == null ? clientname == null : c.name.equals(clientname)){
                client = c;
                break;
            }
        }
        if(client == null){
            System.out.println("Client not found!");
            return;
        }
        System.out.println("Enter Vehicle Plate Number: ");
        int plateNumber = sc.nextInt();
        Vehicle vehicle = null;
        for(Vehicle v : vehicles){
            if(v.plateNumber == plateNumber){
                vehicle = v;
                break;
            }
        }
        if(vehicle == null){
            System.out.println("Vehicle not found!");
            return;
        }
        if(!vehicle.isAvailable){
            System.out.println("Vehicle is not available!");
            return;
        }
        System.out.println("Enter Start Date (YYYY-MM-DD): ");
        String startDateStr = sc.next();
        LocalDate startDate = LocalDate.parse(startDateStr);
        System.out.println("Enter Duration In Days: ");
        int durationInDays = sc.nextInt();
        
        Contract contract = new Contract(client, vehicle, startDate, durationInDays);
        contracts.add(contract);
        vehicle.isAvailable = false;
    }
    public static void closeContract(int platenumber, ArrayList<Contract> contracts)
    
    {
    for(Contract c : contracts){
        if(c.Vehicle.plateNumber == (platenumber) && !c.isClosed){
            c.isClosed = true;
            c.Vehicle.isAvailable = true;
            double fine = c.calculateFine();
            c.displayInfo();
            System.out.println("Contract closed. Fine: " + fine);
            return;
        }
    }

}
 public static void DisplayAllContracts(ArrayList<Contract> contracts){
              for(Contract c : contracts){
                  c.displayInfo();
              }
          }
}

