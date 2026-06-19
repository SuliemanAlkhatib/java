import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
public class Main {
    public static JPanel VehiclesPanel(CardLayout card,JPanel container){
        JPanel Vehicles = new JPanel(new GridLayout(5,1,0,10));
        Vehicles.setBorder(new EmptyBorder(20,250,20,250));
        JButton addVehicles =new JButton("Add Vehicles");
        JButton removeVehicle =new JButton("Remove Vehicles");
        JButton DisplayA =new JButton("Display Available Vehicles");
        JButton DisplayU =new JButton("Display UnAvailable\n Vehicles");
        JButton ExitmVehicles =new JButton("Exit Vehicles");

        Vehicles.add(addVehicles);
        Vehicles.add(removeVehicle);
        Vehicles.add(DisplayA);
        Vehicles.add(DisplayU);
        Vehicles.add(ExitmVehicles);
        
        ExitmVehicles.addActionListener(e->card.show(container, "MainMenuCard"));
        return Vehicles;

    }
    public static void reports(ArrayList<Contract> contracts, ArrayList<Vehicle> vehicles, ArrayList<Client> clients){
        int choice;
        Scanner sc = new Scanner(System.in);
        do{
        System.out.println("\nEnter\n1 to show revenue report, \n2 to show most rented vehicles,\n3 to show VIP clients,\n0 to go back: ");
         choice= sc.nextInt();
        if(choice == 0){
            break;
        }
        switch(choice){
            case 1:
                ReportsManagement.revenueReport(contracts);
                break;
            case 2:
                ReportsManagement.mostRentedVehicles(vehicles);
                break;
            case 3:
                ReportsManagement.VipClients(clients);
                break;
            default:
                System.out.println("Invalid Choice");
        }}while(true);
    }
    public static void contracts(ArrayList<Contract> contracts, ArrayList<Client> clients, ArrayList<Vehicle> vehicles){
        int choice=0;
        Scanner sc = new Scanner(System.in);
        do{
        System.out.println("Enter\n1 to Open Contract, \n2 to search Contract,\n3 to Filter Contracts,\n4 to Close Contract,\n0 to go back: ");
         choice= sc.nextInt();
        if(choice == 0){
            break;
        }
        switch(choice){
            case 1:
                ContractsManagement.addContract(contracts, clients, vehicles);
                break;
            case 2:
                ContractsManagement.searchContract(contracts, clients);
                break;
            case 3:
                ContractsManagement.DisplayAllContracts(contracts,vehicles);
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
        System.out.println("\nEnter\n1 to add vehicle, \n2 to search vehicle,\n3 to show vehicle,\n4 to remove vehicle,\n5 to Display Available Vehicles,\n6 to Display Unavailable Vehicles,\n0 to go back: ");
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
        int choice;
        Scanner sc = new Scanner(System.in);
        do{
        System.out.println("\nEnter\n1 to add client, \n2 to search client,\n3 to show client ,\n4 to update client,\n0 to go back: ");
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
   /*  public static void main(String[] args) {
        

        Scanner sc = new Scanner(System.in);
        int choice =0;
        ArrayList<Client> clients = new ArrayList<>();
        ArrayList<Contract> contracts = new ArrayList<>();
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        clients.add(new Person("Sulieman","39034","3gfd","2343532",LocalDate.of(2008,4,13)));  
        vehicles.add(new Car(1234,"Toyota","Corolla",100,"Gasoline",5));
       vehicles.add(new Car(122334,"BMW","X5",200,"Diesel",5));
        clients.add(new Person("Maya","34243","fds","324324",LocalDate.of(2000,4,13))); 
    do{
        System.out.println("\nEnter \n1 to manage clients\n2 to manage vehicles\n3 to manage Contract\n4 to generate reports\n0 to quit: ");
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
            case 4:
                reports(contracts, vehicles, clients);
                break;
            default:
                System.out.println("Invalid Choice");
        }
    }while(true);

    }*/

    public static void main(String[] args) {
        // Run the GUI creation code on the Event Dispatch Thread (EDT)
        JFrame jframe = new JFrame("Vehicle Renting System");
        jframe.setSize(800,600);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        CardLayout card = new CardLayout();
        JPanel mainContainer = new JPanel(card);
        
        JPanel mainMenu = new JPanel(new GridLayout(4,1,0,30));
        
        mainMenu.setBorder(new EmptyBorder(20,300,20,300));
        JButton mVehicles =new JButton("Manage Vehicles");
        JButton mClients =new JButton("Manage Clients");
        JButton mContracts =new JButton("Manage Contracts");
        JButton exit =new JButton("Exit");
        mainMenu.add(mVehicles);
        mainMenu.add(mClients);
        mainMenu.add(mContracts);
        mainMenu.add(exit);
        
        
        /*JPanel Vehicles = new JPanel(new GridLayout(5,1,0,30));
        
        
        Vehicles.setBorder(new EmptyBorder(20,300,20,300));
        //1 to add vehicle, \n2 to search vehicle,\n3 to show vehicle,\n4 to remove vehicle,\n5 to Display Available Vehicles,\n6 to Display Unavailable Vehicles,\n0 to go back:
JButton addVehicles =new JButton("Add Vehicles");
JButton removeVehicle =new JButton("Remove Vehicles");
JButton DisplayA =new JButton("Display Available Vehicles");
JButton DisplayU =new JButton("Display UnAvailable Vehicles");
JButton ExitmVehicles =new JButton("Exit Vehicles");

        Vehicles.add(addVehicles);
        Vehicles.add(removeVehicle);
        Vehicles.add(DisplayA);
        Vehicles.add(DisplayU);
        Vehicles.add(ExitmVehicles);
*/      JPanel Vehicles = VehiclesPanel(card, mainContainer);
        mainContainer.add(mainMenu,"MainMenuCard");
        mainContainer.add(Vehicles,"VehiclesCard");

        mVehicles.addActionListener(e-> card.show(mainContainer,"VehiclesCard"));
        //ExitmVehicles.addActionListener(e->card.show(mainContainer, "MainMenuCard"));
        exit.addActionListener(e->System.exit(0));

        jframe.add(mainContainer);
        jframe.setVisible(true);
    }
}