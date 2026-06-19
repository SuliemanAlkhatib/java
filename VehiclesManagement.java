import java.util.ArrayList;
import java.util.Scanner;
public class VehiclesManagement {
    public static void AddVehicle(ArrayList<Vehicle> vehicles){
          Scanner sc = new Scanner(System.in);
          System.out.println("Enter the type of vehicle (1 for Bike, 2 for Truck,3 for Car): ");
          int type = sc.nextInt();
          if(type <1 || type>3){
              System.out.println("Invalid vehicle type!");
              return;
           }
          System.out.println("Enter Plate Number: ");
          int plateNumber =sc.nextInt();
          System.out.println("Enter Company: ");
          String company = sc.next();
          System.out.println("Enter Model: ");
          String model = sc.next();
          System.out.println("Enter Daily Cost: ");
          double dayleyCost = sc.nextDouble();
        switch (type) {
            case 1:
                System.out.println("Enter Engine Capacity: ");
                double engineCapacity = sc.nextDouble();
                System.out.println("Enter Has Side Seat (true/false): ");
                boolean hasSideSeat = sc.nextBoolean();
                vehicles.add(new Bike(plateNumber, company, model, dayleyCost, engineCapacity, hasSideSeat));
                System.out.println("Vehicle added successfully!");
                return;
            case 2:
                System.out.println("Enter Load Capacity: ");
                double loadCapacity = sc.nextDouble();
                System.out.println("Enter Has Cooling System (true/false): ");
                boolean hasCoolingSystem = sc.nextBoolean();
                 
                vehicles.add(new Truck(plateNumber, company, model, dayleyCost, loadCapacity, hasCoolingSystem));
                System.out.println("Vehicle added successfully!");
                break;
            case 3:
                System.out.println("Enter Gas Type: 1 Gasoline, 2 Diesel, 3 Electric: ");
                int gasTypeChoice = sc.nextInt();
                String gasType;
                switch (gasTypeChoice) {
                    case 1:
                        gasType = "Gasoline";
                        break;
                    case 2:
                        gasType = "Diesel";
                        break;
                    case 3:
                        gasType = "Electric";
                        break;
                    default:
                        gasType = "Error gas type";
                        break;
                }
                System.out.println("Enter Number Of Seats: ");
                int numberOfSeats = sc.nextInt();
                vehicles.add(new Car(plateNumber, company, model, dayleyCost, gasType, numberOfSeats));
                System.out.println("Vehicle added successfully!");
                break;
            default:
                System.out.println("  ");
                break;
        }
        }
          public static void RemoveVehicle(ArrayList<Vehicle> vehicles, int plateNumber){
              for(Vehicle v : vehicles){
                  if(v.plateNumber == plateNumber){
                      vehicles.remove(v);
                      System.out.println("Vehicle removed successfully!");
                      return;
                  }

              }
                System.out.println("Vehicle Not Found");
          }
          public static void SearchVehicle(ArrayList<Vehicle> vehicles, int plateNumber){
              for(Vehicle v : vehicles){
                  if(v.plateNumber == plateNumber){
                      v.displayInfo();
                      return;
                  }
              }
              System.out.println("Vehicle Not Found");
          }
          public static void DisplayAllVehicles(ArrayList<Vehicle> vehicles){
            if(vehicles.isEmpty()){
                System.out.println("No vehicles found!");
                return;
            }
              for(Vehicle v : vehicles){
                  v.displayInfo();
              }
          }
          public static void DisplayAvailableVehicles(ArrayList<Vehicle> vehicles){
            int count = 0;
              for(Vehicle v : vehicles){
                  if(v.isAvailable){
                      v.displayInfo();
                      count++;
                  }
              }
              if(count == 0){
                  System.out.println("No available vehicles found!");
              }
          }
          public static void DisplayUnAvailableVehicles(ArrayList<Vehicle> vehicles){
            int count = 0;
              for(Vehicle v : vehicles){
                  if(!v.isAvailable){
                      v.displayInfo();
                        count++;

                  }
              }
              if(count == 0){
                  System.out.println("No unavailable vehicles found!");
              }
          }

}
