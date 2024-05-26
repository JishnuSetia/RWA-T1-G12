import java.util.Scanner;

public class stringManipulation {
    String[] s;
    String full;

    public stringManipulation(String s) {
        full = s;
        String[] tmp = s.split(" ");
        int ind = 0;
        this.s = new String[instanceCounter(s, '!') + instanceCounter(s, '?') + 1];
        for (int i = 0; i < this.s.length; i++) {
            String t = "";
            while (true) {
                t += " " + tmp[ind];
                if (tmp[ind].charAt(tmp[ind].length() - 1) == '!' || tmp[ind].charAt(tmp[ind].length() - 1) == '?'
                        || ind + 1 == tmp.length) {
                    break;
                }
                ind++;
            }
            this.s[i] = t;
        }
    }
    public stringManipulation() {
        accept();
    }
    public int instanceCounter(String s, char target) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.toString(s.charAt(i)).equalsIgnoreCase(Character.toString(target))) {
                sum += 1;
            }
        }
        return sum;
    }
    public void accept() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String s = sc.nextLine().trim();
        sc.close();
        full=s;
        String[] tmp = s.split(" ");
        int ind = 0;
        this.s = new String[instanceCounter(s, '!') + instanceCounter(s, '?') + 1];
        for (int i = 0; i < this.s.length; i++) {
            String t = "";
            while (true) {
                t += " " + tmp[ind];
                if (tmp[ind].charAt(tmp[ind].length() - 1) == '!' || tmp[ind].charAt(tmp[ind].length() - 1) == '?'
                        || ind + 1 == tmp.length) {
                    ind++;
                    break;
                }
                ind++;
            }
            this.s[i] = t;
        }
    }
    public void wordCounter() {
        System.out.println("S.No\tWords");
        for(int i = 0;i<s.length;i++){
            System.out.println((i+1)+"\t"+s[i].trim().split(" ").length);
        }
    }
    public void vowelCounter(){
        System.out.println("Vowel\tInstances");
        System.out.println("A\t"+instanceCounter(full, 'A'));
        System.out.println("E\t"+instanceCounter(full, 'E'));
        System.out.println("I\t"+instanceCounter(full, 'I'));
        System.out.println("O\t"+instanceCounter(full, 'O'));
        System.out.println("U\t"+instanceCounter(full, 'U'));
    }
    public String arrangeSentence(String s){
        String punc =Character.isLetter(s.charAt(s.length()-1))||Character.isDigit(s.charAt(s.length()-1))?" ":Character.toString(s.charAt(s.length()-1));
        String[] tmp = s.toLowerCase().substring(0,Character.isLetter(s.charAt(s.length()-1))||Character.isDigit(s.charAt(s.length()-1))?s.length():s.length()-1).split(" ");
        String finalString = "";
        for(int i = 0;i<tmp.length-1;i++){
            for(int j=0;j<tmp.length-1-i;j++){
                if(tmp[j].compareTo(tmp[j+1])>=0){
                    String t = tmp[j];
                    tmp[j] = tmp[j+1];
                    tmp[j+1] = t;
                }
            }
        }
        for(String st:tmp){
            if(st.length()!=0){
                finalString+=Character.toUpperCase(st.charAt(0))+st.substring(1)+" ";
            }
        }
        return finalString.substring(0,finalString.length()-1)+punc;
    }
    public void arrangeSentences(){
        for(String s:this.s){
            System.out.println(arrangeSentence(s));
        }
    }
    public String toPiglatin(String s){
        if(s.length()==0){
            return "";
        }
        String punc =Character.isLetter(s.charAt(s.length()-1))||Character.isDigit(s.charAt(s.length()-1))?" ":Character.toString(s.charAt(s.length()-1));
        String letters = s.substring(0, Character.isLetter(s.charAt(s.length()-1))||Character.isDigit(s.charAt(s.length()-1))?s.length():s.length()-1);
        if(Character.toUpperCase(letters.charAt(0))=='A'||Character.toUpperCase(letters.charAt(0))=='E'||Character.toUpperCase(letters.charAt(0))=='I'||Character.toUpperCase(letters.charAt(0))=='O'||Character.toUpperCase(letters.charAt(0))=='U'){
            return letters+"way"+punc;
        }
        else{
            while(true){
                if(Character.toUpperCase(letters.charAt(0))=='A'||Character.toUpperCase(letters.charAt(0))=='E'||Character.toUpperCase(letters.charAt(0))=='I'||Character.toUpperCase(letters.charAt(0))=='O'||Character.toUpperCase(letters.charAt(0))=='U'){
                    break;
                }
                letters = letters.substring(1).concat(Character.toString(letters.charAt(0)));
            }
        }
        return letters+"ay"+punc;
    }
    public void toPiglatinSentence(){
        for(String s:this.s){
            String[] sub = s.split(" ");
            for(String j:sub){
                System.out.print(toPiglatin(j));
            }
        }
    }
    public static void main(String[] args) {
        stringManipulation sm = new stringManipulation();
        sm.wordCounter();
        System.out.println();
        sm.arrangeSentences();
        System.out.println();
        sm.vowelCounter();
        System.out.println();
        sm.toPiglatinSentence();
    }
}