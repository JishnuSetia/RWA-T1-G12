import java.util.*;

public class caesarCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inText;
        while(true){
            System.out.println("Enter String to Encrypt:");
            inText = sc.nextLine().trim();
            if(inText.length()>3&&inText.length()<100){
                break;
            }else{
                System.out.println("Invalid Input! Try Again");
            }
        }
        sc.close();
        String[] wrds = inText.split(" ");
        String newString = "";
        for(int j=0;j<wrds.length;j++){
            String tmp = "";
            for(int i =wrds[j].length()-1;i>=0 ;i--) {
                tmp=tmp.concat(Character.toString(wrds[j].charAt(i)));
            }
            if(!(tmp.charAt(0)>=97&&tmp.charAt(0)<=122)&&!(tmp.charAt(0)>=65&&tmp.charAt(0)<=90)){
                for(int i=0;i<tmp.length();i++){
                    if(!(tmp.charAt(0)>=97&&tmp.charAt(0)<=122)&&!(tmp.charAt(0)>=65&&tmp.charAt(0)<=90)){
                        tmp = tmp.substring(1).concat(Character.toString(tmp.charAt(0)));
                    }else{
                        break;
                    }
                }
            }
            newString = newString.concat(tmp.concat(" "));
        }
        newString = newString.trim();
        System.out.println(newString);
        int shift=13;
        String finalString = "";
        for(int i = 0;i<newString.length() ;i++) {
            if ((newString.charAt(i) >= 97 && newString.charAt(i) <= 122)) {
                int shiftedValue = (int) newString.charAt(i) + shift;
                if (shiftedValue > 122) {
                    shiftedValue -= 26; 
                }
                finalString = finalString.concat(Character.toString((char) shiftedValue));
            } else if ((newString.charAt(i) >= 65 && newString.charAt(i) <= 90)) {
                int shiftedValue = (int) newString.charAt(i) + shift;
                if (shiftedValue > 90) {
                    shiftedValue -= 26; 
                }
                finalString = finalString.concat(Character.toString((char) shiftedValue));
            } else {
                finalString = finalString.concat(Character.toString(newString.charAt(i)));
            }            
        }
        System.out.println(finalString);
    }
}
