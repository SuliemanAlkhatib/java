import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class Person  extends Client {
    
    protected String drivingLicenseNumber;
    protected LocalDate dateOfBirth;
    Person(String name, String phoneNumber, String Address, String drivingLicenseNumber, LocalDate dateOfBirth) {
        super( name, phoneNumber, Address);
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.dateOfBirth = dateOfBirth;
        if((int)ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now())<25){
            this.rate = 0.15;
        }
    }
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Driving License Number: "+drivingLicenseNumber);
        System.out.println("Date of Birth: "+dateOfBirth.getDayOfMonth()+"/"+dateOfBirth.getMonthValue()+"/"+dateOfBirth.getYear());
        System.out.println("Rate: "+rate);
        System.out.println("=======================================================");
    }
    
}
