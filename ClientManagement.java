import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
public class ClientManagement {
    public static void AddClient(ArrayList<Client> clients){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Client Type (1 for Individual, 2 for Corporate): ");
        int type = sc.nextInt();
        
        System.out.println("Enter Name: ");
        String name = sc.next();
        System.out.println("Enter Phone Number: ");
        String phoneNumber = sc.next();
        System.out.println("Enter Address: ");
        String address = sc.next();
        if(type == 1){
            System.out.println("Enter Date of Birth (day month year): ");
            int day = sc.nextInt();
            int month = sc.nextInt();
            int year = sc.nextInt();
            System.out.println("Enter drivingLicenseNumber: ");
            String drivingLicenseNumber = sc.next();
            clients.add(new Person( name, phoneNumber, address, drivingLicenseNumber, LocalDate.of(year, month, day)));
        }
        else if(type == 2){
            System.out.println("Enter Tax Number: ");
            String taxNumber = sc.next();
            System.out.println("Enter Rate: ");
            double rate = sc.nextDouble();
            clients.add(new Corporate( name, phoneNumber, address, taxNumber, rate));
        }
    }
    public static void searchClient(ArrayList<Client> clients, String name){
        for(Client c : clients){
            if(c.name.equals(name)){
                c.displayInfo();
                break;
            }
        }
    }
    public static void ShowClients(ArrayList<Client> clients){
        for(Client c : clients){
            c.displayInfo();
        }
    }
    public static void UpdateClient(ArrayList<Client> clients, String name){
        for(Client c : clients){
            if(c.name.equals(name)){
                Scanner sc = new Scanner(System.in);
                
                System.out.println("Enter New Phone Number: ");
                String phoneNumber = sc.next();
                System.out.println("Enter New Address: ");
                String address = sc.next();
                c.phoneNumber = phoneNumber;
                c.Address = address;
                if(c instanceof Person){
                    System.out.println(" drivingLicenseNumber: ");
                    String Id = sc.next();
                    ((Person) c).drivingLicenseNumber = Id;
                }
                else if(c instanceof Corporate){
                    System.out.println("Enter New Tax Number: ");
                    String taxNumber = sc.next();
                    System.out.println("Enter New Rate: ");
                    double rate = sc.nextDouble();
                    ((Corporate) c).taxNumber = taxNumber;
                    ((Corporate) c).rate = rate;
                }
                break;
            }
        }
    }
}