import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void contracts(ArrayList<Contract> contracts, ArrayList<Client> clients, ArrayList<Vehicle> vehicles){
        int choice=0;
        Scanner sc = new Scanner(System.in);
        do{
        System.out.println("Enter\n 1 to Open Contract, \n 2 to search Contract,\n 3 to Show All Contracts,\n 4 to Close Contract,\n 0 to go back: ");
         choice= sc.nextInt();
        if(choice == 0){
            break;
        }
        switch(choice){
            case 1:
                ContractsManagement.addContract(contracts, clients, vehicles);
                break;
            case 2:
                System.out.println("Enter Vehicle Plate Number: ");
                int searchId = sc.nextInt();
                VehiclesManagement.SearchVehicle(vehicles, searchId);
                break;
            case 3:
                ContractsManagement.DisplayAllContracts(contracts);
                break;
            case 4:
                System.out.println("Enter The rented Vehicle Plate Number: ");
                int plateNumber = sc.nextInt();
                ContractsManagement.closeContract(plateNumber, contracts);
                break;
            default:
                System.out.println("Invalid Choice");
        }
    }while(true);
    }
    public static void vehicles(ArrayList<Vehicle> vehicles){
        int choice;
        Scanner sc = new Scanner(System.in);
        do{
        System.out.println("\nEnter\n 1 to add vehicle, \n 2 to search vehicle,\n 3 to show vehicle,\n 4 to remove vehicle,\n 5 to Display Available Vehicles,\n 6 to Display Unavailable Vehicles,\n 0 to go back: ");
         choice= sc.nextInt();
        if(choice == 0){
            break;
        }
        switch(choice){
            case 1:
                VehiclesManagement.AddVehicle(vehicles);
                break;
            case 2:
                System.out.println("Enter Vehicle Plate Number: ");
                int searchId = sc.nextInt();
                VehiclesManagement.SearchVehicle(vehicles, searchId);
                break;
            case 3:
                VehiclesManagement.DisplayAllVehicles(vehicles);
                break;
            case 4:
                System.out.println("Enter Vehicle Plate Number: ");
                int plateNumber = sc.nextInt();
                VehiclesManagement.RemoveVehicle(vehicles, plateNumber);
                break;
            case 5:
                VehiclesManagement.DisplayAvailableVehicles(vehicles);
                break;
            case 6:
                VehiclesManagement.DisplayUnAvailableVehicles(vehicles);
                break;
            default:
                System.out.println("Invalid Choice");
        }
    }while(true);
    }
    public static void clients(ArrayList<Client> clients){
        int choice=0;
        Scanner sc = new Scanner(System.in);
        do{
        System.out.println("\nEnter\n 1 to add client, \n 2 to search client,\n 3 to show client ,\n 4 to update client,\n 0 to go back: ");
         choice= sc.nextInt();
        if(choice == 0){
            break;
        }
        switch(choice){
            case 1:
                ClientManagement.AddClient(clients);
                break;
            case 2:
                System.out.println("Enter Client's Name: ");
                String searchName = sc.next();
                ClientManagement.searchClient(clients, searchName);
                break;
            case 3:
                 ClientManagement.ShowClients(clients);
                break;
            case 4:
                System.out.println("Enter Client's Name: ");
                String updateName = sc.next();
                ClientManagement.UpdateClient(clients, updateName);
                break;
            default:
                System.out.println("Invalid Choice");
        }
    }while(true);
    }
    public static void main(String[] args) {
        

        Scanner sc = new Scanner(System.in);
        int choice =0;
        ArrayList<Client> clients = new ArrayList<>();
        ArrayList<Contract> contracts = new ArrayList<>();
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        clients.add(new Person("Sulieman","39034","3gfd","2343532",LocalDate.of(2008,4,13)));  
        vehicles.add(new Car(1234,"Toyota","Corolla",100,"Gasoline",5));
     
    do{
        System.out.println("\nEnter \n1 to manage clients\n2 to manage vehicles\n3 to manage Contract\n0 to quit: ");
         choice= sc.nextInt();
        if(choice == 0){
            break;
        }
        switch(choice){
            case 1:
                clients(clients);
                break;
            case 2:
                vehicles(vehicles);
                break;
            case 3:
                contracts(contracts,clients,vehicles);
                break;
            default:
                System.out.println("Invalid Choice");
        }
    }while(true);
    
    }
}