import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
public class Main {
    public static JPanel VehiclesPanel(CardLayout card,JPanel container){
        JPanel Vehicles = new JPanel(new GridLayout(5,1,0,10));
        Vehicles.setBorder(new EmptyBorder(20,250,20,250));
        JButton addVehicles =new JButton("Add Vehicles");
        JButton removeVehicle =new JButton("Remove Vehicles");
        JButton DisplayA =new JButton("Display Available Vehicles");
        JButton DisplayU =new JButton("<html>Display UnAvailable<br> Vehicles</html>");
        JButton ExitmVehicles =new JButton("Exit Vehicles");

        Vehicles.add(addVehicles);
        Vehicles.add(removeVehicle);
        Vehicles.add(DisplayA);
        Vehicles.add(DisplayU);
        Vehicles.add(ExitmVehicles);
        DisplayA.addActionListener(e->card.show(container, "ShowCard"));
        addVehicles.addActionListener(e->card.show(container, "AddVehiclesCard"));
        removeVehicle.addActionListener(e->card.show(container, "RemoveVehiclesCard"));
        DisplayU.addActionListener(e->card.show(container, "DisplayUnAvailableCard"));
        ExitmVehicles.addActionListener(e->card.show(container, "MainMenuCard"));
        return Vehicles;

    }
    public static JPanel addVehiclesPanel(CardLayout card,JPanel container,ArrayList<Vehicle> vehicles){
        JPanel addVehicles = new JPanel(new GridLayout(2,1,0,10));
        addVehicles.setBorder(new EmptyBorder(20,250,20,250));
        JButton addVehicle =new JButton("Start Adding Vehicle");
        JButton ExitmVehicles =new JButton("Exit Vehicles");

        addVehicles.add(addVehicle);
        addVehicles.add(ExitmVehicles);
        addVehicle.addActionListener(e->card.show(container, "AddVehiclesFormCard"));
        ExitmVehicles.addActionListener(e->card.show(container, "MainMenuCard"));
        return addVehicles;

    }
    public static JPanel removeVehiclesPanel(CardLayout card,JPanel container,ArrayList<Vehicle> vehicles){
        JPanel removeVehicles = new JPanel(new GridLayout(2,1,0,10));
        removeVehicles.setBorder(new EmptyBorder(20,250,20,250));
        JButton removeVehicle =new JButton("Start Removing Vehicle");
        JButton ExitmVehicles =new JButton("Exit Vehicles");

        removeVehicles.add(removeVehicle);
        removeVehicles.add(ExitmVehicles);
        removeVehicle.addActionListener(e->{
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Vehicle Plate Number: ");
            int plateNumber = sc.nextInt();
            VehiclesManagement.RemoveVehicle(vehicles, plateNumber);
        });
        ExitmVehicles.addActionListener(e->card.show(container, "MainMenuCard"));
        return removeVehicles;

    }
    public static JPanel DisplayUnAvailableVehiclesPanel(CardLayout card,JPanel container,ArrayList<Vehicle> vehicles){
        JPanel DisplayUnAvailableVehicles = new JPanel(new GridLayout(2,1,0,10));
        DisplayUnAvailableVehicles.setBorder(new EmptyBorder(20,250,20,250));
        JButton DisplayUnAvailableVehicle =new JButton("Start Displaying UnAvailable Vehicle");
        JButton ExitmVehicles =new JButton("Exit Vehicles");

        DisplayUnAvailableVehicles.add(DisplayUnAvailableVehicle);
        DisplayUnAvailableVehicles.add(ExitmVehicles);
        DisplayUnAvailableVehicle.addActionListener(e->VehiclesManagement.DisplayUnAvailableVehicles(vehicles));
        ExitmVehicles.addActionListener(e->card.show(container, "MainMenuCard"));
        return DisplayUnAvailableVehicles;

    }
    public static JPanel showVehicles(CardLayout card,JPanel container){
        ArrayList<Vehicle> vehicles = new ArrayList<>(); 
        vehicles.add(new Car(1234,"Toyota","Corolla",100,"Gasoline",5));
       vehicles.add(new Car(122334,"BMW","X5",200,"Diesel",5));


        JPanel Vehicles = new JPanel();
        Vehicles.setLayout(new BoxLayout(Vehicles, BoxLayout.Y_AXIS));
        Vehicles.setBorder(new EmptyBorder(20,250,20,250));

        JLabel header = new JLabel("-----Inventory Cars-----");
        header.setAlignmentX(Component.CENTER_ALIGNMENT);
        Vehicles.add(header);
        for(Vehicle v:vehicles){
            String htmlText = "<html>" + v.toString().replace("\n", "<br>") + "</html>";
            JLabel item = new JLabel(htmlText);
            item.setAlignmentX(Component.CENTER_ALIGNMENT);
            Vehicles.add(item);
            JLabel footer = new JLabel("--------------------");
        footer.setAlignmentX(Component.CENTER_ALIGNMENT);
        Vehicles.add(footer);
        }
        return Vehicles;
    }
    public static JPanel addVehiclesFormPanel(CardLayout card,JPanel container,ArrayList<Vehicle> vehicles){
        JTextField plateNumberField = new JTextField();
        JTextField companyField = new JTextField();
        JTextField modelField = new JTextField();
        JTextField dayleyCostField = new JTextField();
        JTextField gasTypeField = new JTextField();
        JTextField numberOfSeatsField = new JTextField();
        JPanel p = new JPanel(new GridLayout(8,2,10,10));
        p.setBorder(new EmptyBorder(20,250,20,250));
        JButton save=new JButton("Save Vehicle");
        JButton back =new JButton("Back");
        p.add(new JLabel("Plate Number:"));
        p.add(plateNumberField);
        p.add(new JLabel("Company:"));
        p.add(companyField);
        p.add(new JLabel("Model:"));
        p.add(modelField);
        p.add(new JLabel("Daily Cost:"));
        p.add(dayleyCostField);
        p.add(new JLabel("Gas Type:"));
        p.add(gasTypeField);
        p.add(new JLabel("Number of Seats:"));
        p.add(numberOfSeatsField);
        p.add(save);
        p.add(back);
        save.addActionListener(e->{
           
                int plateNumber = Integer.parseInt(plateNumberField.getText());
                String company = companyField.getText();
                String model = modelField.getText();
                double dayleyCost = Double.parseDouble(dayleyCostField.getText());
                String gasType = gasTypeField.getText();
                int numberOfSeats = Integer.parseInt(numberOfSeatsField.getText());
                vehicles.add(new Car(plateNumber, company, model, dayleyCost, gasType, numberOfSeats));
                JOptionPane.showMessageDialog(p, "Vehicle added successfully!");
            
        plateNumberField.setText("");
        companyField.setText("");
        modelField.setText("");
        dayleyCostField.setText("");
        gasTypeField.setText("");
        numberOfSeatsField.setText("");
    });
        return p;
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
JPanel show = showVehicles(card, mainContainer);
        mainContainer.add(mainMenu,"MainMenuCard");
        mainContainer.add(show,"ShowCard");
        mainContainer.add(Vehicles,"VehiclesCard");
        mainContainer.add(removeVehiclesPanel(card, mainContainer,new ArrayList<Vehicle>()),"RemoveVehiclesCard");
        mainContainer.add(DisplayUnAvailableVehiclesPanel(card, mainContainer,new ArrayList<Vehicle>()),"DisplayUnAvailableCard");
        mainContainer.add(addVehiclesPanel(card, mainContainer,new ArrayList<Vehicle>()),"AddVehiclesCard");
        mainContainer.add(addVehiclesFormPanel(card, mainContainer,new ArrayList<Vehicle>()),"AddVehiclesFormCard");

        mVehicles.addActionListener(e-> card.show(mainContainer,"VehiclesCard"));
        //ExitmVehicles.addActionListener(e->card.show(mainContainer, "MainMenuCard"));
        exit.addActionListener(e->System.exit(0));

        jframe.add(mainContainer);
        jframe.setVisible(true);
    }
}