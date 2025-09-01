import java.util.List;
import java.util.*;

public class LetterBar{
    
    public static int maxLength(String letters){
        List<Character> charList = new ArrayList<Character>();
        int maxLength = 0;
        for (int right = 0; right < letters.length(); right++) {
            if (charList.contains(letters.charAt(right))) {
                char searchChar = letters.charAt(right);
                int index = charList.indexOf(searchChar);
                charList.remove(index);
                if (index > 0) {
                    charList.subList(0, index).clear();
                }
            }
            charList.add(letters.charAt(right));
            maxLength = Math.max(maxLength, charList.size());
        }
        return maxLength;
    }
    
    public static void main(String[] args) {
        System.out.println(maxLength("dengklek"));
        // maxLength("dengklek");
        // maxLength("srm");
        // maxLength("www");
        // maxLength("a");
    }
}
