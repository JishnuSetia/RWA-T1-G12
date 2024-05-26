package inheritance;
import java.util.*;
abstract class Loan {
    String loanAppNo, name, mobile;
    public Loan(){
    }
    public Loan(String loanAppNo, String name, String mobile){
        this.loanAppNo = loanAppNo;
        this.name = name;
        this.mobile = mobile;
    }
    public void accept(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Loan Application Number: ");
        loanAppNo = sc.nextLine();
        System.out.println("\nEnter Name of Applicant :");
        name = sc.nextLine(); 
        while(true){
            System.out.print("Mobile No. (10 Digits) : ");
            mobile = sc.nextLine();
            if(mobile.length()==10){
                boolean chk = true;
                for(int i = 0;i<mobile.length();i++){
                    if(!Character.isDigit(mobile.charAt(i))){
                        chk=false;
                        break;
                    }
                }
                if (chk) {
                    break;
                }
            }
        }
    }
    public void Display(){
        System.out.println("\nLoan Application Number : "+loanAppNo);
        System.out.println("Name of Applicant : "+name);
        System.out.println("Mobile No. : "+mobile);
    }
}
