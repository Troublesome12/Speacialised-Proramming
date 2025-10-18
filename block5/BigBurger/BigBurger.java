public class BigBurger {
    
    public int maxWait(int[] arrival, int[] service) {
        int maxWaitingTime = 0; 
        int currentTime = arrival[0] + service[0];
        for (int i=1; i<arrival.length; i++) {
            if (currentTime < arrival[i]) {
                currentTime = arrival[i] + service[i];
            } else {
                maxWaitingTime = Math.max((currentTime - arrival[i]), maxWaitingTime);
                currentTime += service[i];
            }
        }
        return maxWaitingTime;
    }

    public static void main(String[] args) {
        BigBurger obj = new BigBurger();
        System.out.println(obj.maxWait(new int[]{3,3,9}, new int[]{2,15,14}));      //11
        System.out.println(obj.maxWait(new int[]{182}, new int[]{11}));             //0
        System.out.println(obj.maxWait(new int[]{2,10,11}, new int[]{3,4,3}));      //3
        System.out.println(obj.maxWait(new int[]{2,10,12}, new int[]{15,1,15}));    //7
    }
}
