import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
            sc.close();
            return;
        }
        System.out.println("Enter Vehicle Plate Number: ");
        int plateNumber = sc.nextInt();
        Vehicle vehicle = null;
        for(Vehicle v : vehicles){
            if(v.plateNumber == plateNumber){
                vehicle = v;
                sc.close();
                break;
            }
        }
        if(vehicle == null){
            System.out.println("Vehicle not found!");
            sc.close();
            return;
        }
        if(!vehicle.isAvailable){
            System.out.println("Vehicle is not available!");
            sc.close();
            return;
        }
        /*System.out.println("Enter Start Date (YYYY-MM-DD): ");
        String startDateStr = sc.next();
        LocalDate startDate = LocalDate.parse(startDateStr);*/
        System.out.println("Enter Duration In Days: ");
        int durationInDays = sc.nextInt();
        vehicle.rentCount++;
        client.rentCount++;
        Contract contract = new Contract(client, vehicle, LocalDate.now(), durationInDays);
        contracts.add(contract);
        vehicle.isAvailable = false;
        System.out.println("Contract added successfully!");
        sc.close();
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
    System.out.println("Contract not found or already closed!");
}
public static void searchContract(ArrayList<Contract> contracts){
    Scanner sc = new Scanner(System.in);
    System.out.println("To search by Person name enter 1\nto search by Corporate client name Enter 2: ");
    int choice = sc.nextInt();
    switch(choice){
        case 1:
            System.out.println("Enter Client name: ");
            String clientName = sc.next();
            for(Contract c : contracts){
                if(c.client.name.equals(clientName)){
                    c.displayInfo();
                    sc.close();
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
                    sc.close();
                    return;
                }
            }
            System.out.println("Contract not found!");
            break;
       default: 
       System.out.println("Invalid Choice");
          
    }
    sc.close();
}
public static void DisplayAllContracts(ArrayList<Contract> contracts){
    int choice;
    Scanner scc = new Scanner(System.in);
       while(true){
        
       System.out.println("\nEnter \n1 to display all contracts, \n2 to display only active contracts, \n3 to display only closed contracts ,\n4 to display late contracts, \n5 to display contracts within a specific interval\n0 to exit: ");
      choice  = scc.nextInt();
      scc.close();
      if(choice==0)break;
         switch(choice){
            
              case 1: 
              if(contracts.isEmpty()){
                  System.out.println("No contracts found!");
              }
              for(Contract c : contracts){
                  c.displayInfo();
              }
              break;
              case 2: int i=0;
              for(Contract c : contracts){

                  if(!c.isClosed){
                        i++;
                      c.displayInfo();
                  }
              }
              if(i==0){
                  System.out.println("No active contracts found!");
              }
              break;
              case 3:  i=0;
              for(Contract c : contracts){
                  if(c.isClosed){
                      i++;
                      c.displayInfo();
                  }
              }
              if(i==0){
                  System.out.println("No closed contracts found!");
              }
              break;
              case 4: i=0;
              for(Contract c : contracts){
                c.lateness();
                
                  if(c.lateDays>0){
                      i++;
                      c.Vehicle.displayInfo();
                  }
              }
              if(i==0){
                  System.out.println("No late contracts found!");
              }
              break;
              case 5: {
                Scanner sc = new Scanner(System.in);
                int choice2;
                 System.out.println("1 to search all vehicles 2 to search only bikes");
                    choice2 = sc.nextInt();
                 System.out.println("Enter Start Interval Date (YYYY-MM-DD): ");
               String startDateStr = sc.next();
               LocalDate startDate = LocalDate.parse(startDateStr);
               System.out.println("Enter End Interval Date (YYYY-MM-DD): ");
               String EndDateStr = sc.next();
               LocalDate EndDate = LocalDate.parse(EndDateStr);
               long daysBetween = ChronoUnit.DAYS.between(startDate, EndDate);
                i=0;
               for(Contract c : contracts){
                
                   if(ChronoUnit.DAYS.between(c.startDate, startDate) <= daysBetween ){
                    if(choice2 == 2 && c.Vehicle instanceof Bike){
                        i++;
                    System.out.println("Vehicle "+i+":");
                       c.Vehicle.displayInfo();
                    }else if(choice2==1){
                        i++;
                    System.out.println("Vehicle "+i+":");
                       c.Vehicle.displayInfo();
                    }
                    
                   }
              }
              if(i==0){
                  System.out.println("No contracts found within the specified interval!");
              }
              sc.close();
              
          }break;
          case 6: {
            Scanner sc = new Scanner(System.in);
             System.out.println("Enter the Vehicle Plate Number: ");
              int plateNumber = sc.nextInt();
               i=0;
                for(Contract c : contracts){
                     if(c.Vehicle.plateNumber == plateNumber){
                        i++;
                        System.out.println("Client "+i+":");
                        c.client.displayInfo();
                     }
                }
                if(i==0){
                    System.out.println("No contracts found for the specified vehicle!");
                }
           
          sc.close();}
            break;
                default: System.out.println("Invalid Choice");
}}

}
}