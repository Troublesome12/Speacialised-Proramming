import java.util.*;

public class LetterBar {
    public static int maxLength(String letters) {
        List<Character> charList = new ArrayList<>();
        int maxLength = 0;

        for (int right = 0; right < letters.length(); right++) {
            char current = letters.charAt(right);

            // If duplicate found, remove all characters up to its previous index
            if (charList.contains(current)) {
                int index = charList.indexOf(current);
                charList.remove(index);
                if (index > 0) {
                    charList.subList(0, index).clear();
                }
            }

            // Add current character to the window
            charList.add(current);

            // Update maximum length
            maxLength = Math.max(maxLength, charList.size());
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(maxLength("srm")); // 3
        System.out.println(maxLength("dengklek")); // 6
        System.out.println(maxLength("haha")); // 2
        System.out.println(maxLength("www")); // 1
        System.out.println(maxLength("thisisansrmbeforetopcoderopenfinals")); // 9
    }
}
