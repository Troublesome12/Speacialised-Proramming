public class GameTable {
    
    public int maxArea(String[] board) {
        int length = board.length;
        char [][] boardArray = new char[board[0].length()][length]; 
        
        for (int i = 0; i < length; i++) {
            boardArray[i] = board[i].toCharArray();
        }

        int wide = 1;
        int leftTop = 0;
        int rightTop = 0;
        int j = 0;
        boolean restart = true;

        if (length == 1) return 1;
        if (board[0].length() == 1) return 1;
        for (int i = 0; i < board[0].length(); i++) {
            if (leftTop > 0) {
                j = leftTop;
            }
            else {
                j = 0;
            }
            for (;j<length-1;j++) {
                if(boardArray[i][j] == boardArray[i][j+1]) {
                    leftTop = j + 1;
                }

                if (j < length - 2) {
                    rightTop = j + 1;
                }
            }
        }

        return (int) Math.pow(rightTop-leftTop, 2);
    }

    public static void main(String[] args) {
        System.out.println(new GameTable().maxArea(new String[]{"1","0"}));             // 2
        System.out.println(new GameTable().maxArea(new String[]{"0000"}));              // 1
        System.out.println(new GameTable().maxArea(new String[]{"01"}));                // 2
        System.out.println(new GameTable().maxArea(new String[]{"001","000", "100"}));  // 2
    }
}
