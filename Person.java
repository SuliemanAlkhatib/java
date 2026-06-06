import java.time.LocalDate;
public class Person  extends Client {
    public boolean vip=false;
    protected String drivingLicenseNumber;
    protected LocalDate dateOfBirth;
    Person(String name, String phoneNumber, String Address, String drivingLicenseNumber, LocalDate dateOfBirth) {
        super( name, phoneNumber, Address);
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.dateOfBirth = dateOfBirth;
    }
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Driving License Number: "+drivingLicenseNumber);
        System.out.println("Date of Birth: "+dateOfBirth.getDayOfMonth()+"/"+dateOfBirth.getMonthValue()+"/"+dateOfBirth.getYear());
    }
    public void isVip(){
        if(rentCount>5){
            vip=true;
            rate=0.07;
        }
    }
}
