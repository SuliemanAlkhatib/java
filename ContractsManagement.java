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
        vehicle.rentCount++;
        client.rentCount++;
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
public static void searchContract(ArrayList<Contract> contracts){
    Scanner sc = new Scanner(System.in);
    System.out.println("To search by Person name enter 1, to search by Corporate client name Enter 2: ");
    int choice = sc.nextInt();
    switch(choice){
        case 1:
            System.out.println("Enter Client name: ");
            String clientName = sc.next();
            for(Contract c : contracts){
                if(c.client.name.equals(clientName)){
                    c.displayInfo();
                    return;
                }
            }
            System.out.println("Contract not found!");
            break;
        case 2:
            System.out.println("Enter Corporate client name: ");
            String corporateName = sc.next();
            for(Contract c : contracts){
                if(c.client instanceof Corporate && ((Corporate) c.client).name.equals(corporateName)){
                    c.displayInfo();
                    return;
                }
            }
            System.out.println("Contract not found!");
            break;
       
          
    }
}
public static void DisplayAllContracts(ArrayList<Contract> contracts){
       System.out.println("Enter 1 to display all contracts, 2 to display only active contracts, 3 to display only closed contracts: ");
       int choice = new Scanner(System.in).nextInt();
         switch(choice){
              case 1: for(Contract c : contracts){
                  c.displayInfo();
              }
              break;
              case 2: for(Contract c : contracts){
                  if(!c.isClosed){
                      c.displayInfo();
                  }
              }
              break;
              case 3: for(Contract c : contracts){
                  if(c.isClosed){
                      c.displayInfo();
                  }
              }
              case 4: for(Contract c : contracts){
                c.lateness();
                
                  if(c.lateDays>0){
                      c.Vehicle.displayInfo();
                  }
              }
              break;
          }
}

}