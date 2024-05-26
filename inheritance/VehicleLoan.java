package inheritance;
import java.util.Scanner;

public class VehicleLoan extends Loan{
    String vehicleType, registrationNumber;
    public VehicleLoan(){
        accept();
    }
    public VehicleLoan(String loanAppNo, String name, String mobile,String vehicleType, String registrationNumber){
        super(loanAppNo, name, mobile);
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }
    @Override
    public void accept(){
        super.accept();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Vehicle Type : ");
        vehicleType = sc.nextLine();
        System.out.println("\nEnter Registration Number : ");
        registrationNumber = sc.nextLine();
    }
    @Override
    public void Display(){
        super.Display();
        System.out.println(vehicleType);
        System.out.println(registrationNumber);
    }
}
