public class RunLengthEncoding {
    public String decode(String text) {
        StringBuilder decoded = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            int num = 0;
            while (i < text.length() && Character.isDigit(text.charAt(i))) {
                num = num * 10 + (text.charAt(i) - '0');
                i++;
            }
            if (i >= text.length()) break;
            char ch = text.charAt(i++);
            if (num == 0) num = 1;
            if ((long) decoded.length() + num > 50) return "TOO LONG";
            for (int j = 0; j < num; j++) decoded.append(ch);
        }
        return decoded.toString();
    }

    public static void main(String[] args) {
        RunLengthEncoding rle = new RunLengthEncoding();
        System.out.println(rle.decode("4A3BC2DE"));                         // AAAABBBCDDE
        System.out.println(rle.decode("1A1B1C1D1E"));                       // ABCDE
        System.out.println(rle.decode("1A3A5A4BCCCC"));                     // AAAAAAAAA BBBBCCCC
        System.out.println(rle.decode("50A"));                              // AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
        System.out.println(rle.decode("21Z13S9A8M"));                       // TOO LONG
        System.out.println(rle.decode("123456789012345678901234567890B"));  // TOO LONG
    }
}
