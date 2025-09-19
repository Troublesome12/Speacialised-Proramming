public class CastleGuards {
    public int missing(String[] castle) {
        int height = castle.length;
        int length = castle[0].length();

        int missingRows = 0;
        int missingCols = 0;

        boolean foundGuard;

        // Checking for each row
        for (int i = 0; i < height; i++) {
            foundGuard = false;
            for (int j = 0; j < length; j++) {
                if (castle[i].charAt(j) == 'X') {
                    foundGuard = true;
                    break;
                }
            }
            if (!foundGuard) missingRows++;
        }

        // Checking for each column
        for (int j = 0; j < length; j++) {
            foundGuard = false;
            for (int i = 0; i < height; i++) {
                if (castle[i].charAt(j) == 'X') {
                    foundGuard = true;
                    break;
                }
            }
            if (!foundGuard) missingCols++;
        }

        // Final result: max of missing rows and missing cols
        return Math.max(missingRows, missingCols);
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
