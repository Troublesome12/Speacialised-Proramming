public class CastleGuards {
    public int missing(String[] castle) {

        int height = castle.length;
        int length = castle[0].length();
        int count = 0;
        boolean foundGuard = false;


        // Checking for each row
        for(int i=0; i<=height-1; i++) {
            foundGuard = false;
            for(int j=0; j<=length-1; j++) {
                if (castle[i].charAt(j) == 'X') {
                    foundGuard = true;
                    break;
                }
            }

            if (!foundGuard) count++;

        }

        int result = count;

        // Checking for each column
        for(int i=0; i<=length-1; i++) {
            foundGuard = false;
            for(int j=0; j<=height-1; j++) {
                if (castle[j].charAt(i) == 'X') {
                    foundGuard = true;
                    break;
                }
            }

            if (!foundGuard) {
                count--;
                if (count < 0) {
                    result++;
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new CastleGuards().missing(new String[]
            { 
                "....",
                "....",
                "....",
                "...." 
            }));                    // Expected 4
        System.out.println(new CastleGuards().missing(new String[]
            { 
                "XX...",
                ".XX..",
                "...XX" 
            }));                    // Expected 0
        System.out.println(new CastleGuards().missing(new String[]
            { 
                "....XXXX",
                "........",
                "XX.X.XX.",
                "........",
                "........" 
            }));                    // Expected 3
        System.out.println(new CastleGuards().missing(new String[]
            { 
                "........X..",
                "...X.......",
                "...........",
                "..X...X....",
                "...........",
                "...........",
                "........X..",
                "...........",
                "...........",
                "........X..",
                ".....X....." 
            }));                    // Expected 6
    }
}
