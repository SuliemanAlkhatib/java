
import java.util.ArrayList;

class ReportsManagement {
    public static void revenueReport(ArrayList<Contract> contracts){
        double totalRevenue = 0.0;
        for(Contract c : contracts){
            if(c.isClosed){
                totalRevenue += c.calculateFine();
            }
            
        }
        System.out.println("Total Revenue: "+totalRevenue);
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