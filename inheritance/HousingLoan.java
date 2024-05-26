package inheritance;
import java.util.*;
final public class HousingLoan extends Loan{
    String builtUpArea, location;   
    public HousingLoan(){
        accept();
    }
    public HousingLoan(String loanAppNo, String name, String mobile, String builtUpArea, String location){
        super(loanAppNo, name, mobile);
        this.builtUpArea = builtUpArea;
        this.location = location;
    }
    @Override
    public void accept(){
        super.accept();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Built Up Area of Property : ");
        builtUpArea = sc.nextLine();
        System.out.println("\nEnter the Location of Property (City Name) : ");
        location = sc.nextLine();
    }
    @Override
    public void Display(){
        super.Display();
        System.out.println(builtUpArea);
        System.out.println(location);
    }
}
