public class SquareOfDigits {
    
    public int getMax(String[] data) {
        int rows = data.length;
        int cols = data[0].length();
        int maxSquareSize = 1;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int size = 1; i + size < rows && j + size < cols; size++) {
                    char leftTop = data[i].charAt(j);
                    char rightTop = data[i].charAt(j + size);
                    char leftBottom = data[i + size].charAt(j);
                    char rightBottom = data[i + size].charAt(j + size);

                    if (leftTop == rightTop && 
                    leftBottom == rightBottom &&
                    leftTop == leftBottom) {
                        maxSquareSize = Math.max(maxSquareSize, size + 1);
                    }
                }
            }
        }
        return maxSquareSize*maxSquareSize;
    }
}
