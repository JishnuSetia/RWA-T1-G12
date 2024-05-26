public class encryption {
    public static String technique1(String txt){
        String flip = "";
        for(int i=0;i<txt.length();i++){
            if(txt.charAt(i)==' '){
                continue;
            }
            flip=Character.toString(txt.charAt(i))+flip;
        }
        String text="";
        for(int i=0;i<flip.length();i++){
            if(Integer.parseInt(flip.substring(i,i+2))<65&&Integer.parseInt(flip.substring(i,i+2))!=32){
                if(i+3>flip.length()){
                    text += (char)(Integer.parseInt(flip.substring(i)));
                }else{
                    text += (char)(Integer.parseInt(flip.substring(i,i+3)));
                }
                i+=2;
            }else{
                text += (char)(Integer.parseInt(flip.substring(i,i+2)));
                i++;
            }
        }
        return text;
    }
    public static String technique2(String text) {
        if (text.length() % 7 != 0) {
            while (text.length() % 7 != 0) {
                text = "0" + text;
            }
        }
    
        String[] bin = new String[text.length() / 7];
        int ind = 0;
        for (int i = 0; i < bin.length; i++) {
            String tmp = "";
            for (int j = 0; j < 7; j++) {
                tmp+=text.charAt(ind++);
            }
            bin[i] = tmp.toString();
        }
    
        String text2 = "";
        for (String s : bin) {
            int num = 0;
            for (int j = 0; j < s.length(); j++) {
                num += (int) Math.pow(2, s.length() - 1 - j) * Integer.parseInt(Character.toString(s.charAt(j)));
            }
            text2+=(char) num;
        }
    
        return text2;
    }
}
