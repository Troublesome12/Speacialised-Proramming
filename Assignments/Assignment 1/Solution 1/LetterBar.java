import java.util.HashMap;
import java.util.Map;

public class LetterBar {
    public static int maxLength(String letters){
        int maxLen = -1;
        for (int i=0;i<letters.length();i++){
            for(int j=i+1;j<=letters.length();j++){
                String now = letters.substring(i, j);
            
                int okk = 1;
                Map<Character, Integer> cnt = new HashMap<>();
                
                for(int k=0;k<now.length();k++){
                    Character nowc = now.charAt(k);
                    if(cnt.get(nowc) != null){
                        okk = 0;
                        break;
                    }else{
                        cnt.put(nowc, 1);
                    }
                }
                if(okk == 1){
                    System.out.println(now);
                    maxLen = Math.max(maxLen, now.length());
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(maxLength("vaeimtxcggqndojylwbuhphsr"));
    }
}
