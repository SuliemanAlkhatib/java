
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
class ReportsManagement {
    public static void revenueReport(ArrayList<Contract> contracts){
        System.out.println("Enter\n1 to show total revenue. \n2 to show revenue by vehicle. \n3 to show revenue by client. \n4 to show revenue by month. \n5 to show revenue by date range. \n0 to go back");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch(choice){
            case 1:{
        double totalRevenue = 0.0;
        for(Contract c : contracts){
            if(c.isClosed){
                totalRevenue += c.calculateFine();
            }
            
        }
        System.out.println("Total Revenue: "+totalRevenue);
        break;}
            case 2:{
        System.out.println("Enter Vehicle's Plate Number:");
        int plateNumber = sc.nextInt();
        double vehicleRevenue = 0.0;
        int i=0;
        for(Contract c:contracts){
            if(c.Vehicle.plateNumber == plateNumber && c.isClosed){
                i++;
                vehicleRevenue += c.calculateFine();
            }
        }
        if(i==0){
            System.out.println("No contracts found for this vehicle!");
        }
        else{
        System.out.println("Revenue for Vehicle "+plateNumber+": "+vehicleRevenue);
    }
    }case 3:{
        System.out.println("Enter Client's Name:");
        String name = sc.next();
        double clientRevenue = 0.0;
        int i=0;
        for(Contract c:contracts){
            if(c.client.name.equals(name) && c.isClosed){
                i++;
                clientRevenue += c.calculateFine();
            }
        }
        if(i==0){
            System.out.println("No contracts found for this client!");
        }
        else{
            System.out.println("Revenue for Client "+name+": "+clientRevenue);
        }
    }case 4:{
        System.out.println("Enter Month and Year (month year):");
        int month = sc.nextInt();
        int year = sc.nextInt();
        double monthRevenue = 0.0;
        int i=0;
        for(Contract c:contracts){
            if(c.startDate.getMonthValue() == month && c.startDate.getYear() == year && c.isClosed){
                i++;
                monthRevenue += c.calculateFine();
            }
        }
        if(i==0){
            System.out.println("No contracts found for this month!");
        }
        else{
            System.out.println("Revenue for "+month+"/"+year+": "+monthRevenue);
        }}case 5:{
        System.out.println("Enter Start Interval Date (YYYY-MM-DD): ");
        String startDate = sc.next();
        System.out.println("Enter End Interval Date (YYYY-MM-DD): ");
        String endDate = sc.next();
        double dateRangeRevenue = 0.0;
        int i=0;
        for(Contract c:contracts){
            if(!c.startDate.isAfter(LocalDate.parse(startDate)) && !c.startDate.isBefore(LocalDate.parse(endDate)) && c.isClosed){
                i++;
                dateRangeRevenue += c.calculateFine();
            }
        }
        if(i==0){
            System.out.println("No contracts found for this date range!");
        }
        else{
            System.out.println("Revenue for Date Range "+startDate+" to "+endDate+": "+dateRangeRevenue);
        }
    }default:
        System.out.println("Invalid Choice");
}
}
public static void mostRentedVehicles(ArrayList<Vehicle> vehicles){
    vehicles.sort((v1, v2) -> Integer.compare(v2.rentCount, v1.rentCount));
    System.out.println("Most Rented Vehicles:");
    for(int i=0; i<Math.min(5, vehicles.size()); i++){
        System.out.println((i+1)+". Plate Number: "+vehicles.get(i).plateNumber+",   Rent Count: "+vehicles.get(i).rentCount);
    }
}

public static void VipClients(ArrayList<Client> clients){

    int i=0;
    System.out.println("VIP Clients:");
    for(Client c : clients){
        ((Person) c).isVip();
        if(c instanceof Person p && p.vip){
            i++;
            System.out.println("The Client #"+i+":");
            c.displayInfo();
        }
    }

}

}