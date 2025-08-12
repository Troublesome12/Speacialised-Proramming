import java.util.ArrayList;
import java.util.Collections;

public class PartySeats {

    public String[] seating(String[] attendees) {
        ArrayList<String> boys = new ArrayList<>();
        ArrayList<String> girls = new ArrayList<>();

        for (String attendee : attendees) {
            if (attendee.endsWith("boy")) {
                boys.add(attendee.split(" ")[0]);
            } else {
                girls.add(attendee.split(" ")[0]);
            }
        }
        int length = attendees.length + 2;
        String[] seatingArrangement = new String[length];
        int girlsSize = girls.size();
        int boysSize = boys.size();

        if (girlsSize != boysSize) 
            return new String[0];

        Collections.sort(boys);
        Collections.sort(girls);

        int boyCount = 0;
        int girlCount = 0;
    
        for(int i=0; i<length; i++) {
            if (i == 0) {
                seatingArrangement[i] = "HOST";
            } 
            else if (i == girlsSize + 1) {
                seatingArrangement[i] = "HOSTESS";
            }
            else if (i%2 == 0) {
                seatingArrangement[i] = boys.get(boyCount++);
            } else {
                seatingArrangement[i] = girls.get(girlCount++);
            }
        }

        return seatingArrangement;
    }
}
