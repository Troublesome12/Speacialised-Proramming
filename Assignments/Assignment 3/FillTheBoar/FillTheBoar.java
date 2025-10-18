import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FillTheBoar {
    public int eaten(int stomach, int[] muffins, int delay) {
        Integer[] premitiveMuffins = new Integer[muffins.length];

        for (int i = 0; i< muffins.length; i++) {
            premitiveMuffins[i] = muffins[i];
        }

        Arrays.sort(premitiveMuffins, Collections.reverseOrder());
        int eaten = 0;
        ArrayList<Integer> muffinList = new ArrayList<Integer>(Arrays.asList(premitiveMuffins));
        for (int i = 0; i < muffinList.size(); i++) {
            if (muffinList.get(i) < stomach) {
                stomach -= muffinList.get(i);
                eaten += muffinList.get(i);
                muffinList.remove(i--);
            }
        }
        int run = Math.min(delay+1, muffinList.size());
        for (int i = 0; i < run; i++) {
            eaten += muffinList.get(i);
        }
        return eaten;
    }

    public static void main(String[] args) {
        FillTheBoar obj = new FillTheBoar();
        // System.out.println(obj.eaten(100, new int[]{100, 100, 100}, 0));                    //100
        // System.out.println(obj.eaten(101, new int[]{100, 100, 100}, 0));                    //200
        // System.out.println(obj.eaten(101, new int[]{100, 100, 100, 100, 100}, 2));          //400
        // System.out.println(obj.eaten(4700, new int[]{1000, 8000, 2000, 5000, 3000}, 0));    //12000
        // System.out.println(obj.eaten(100, new int[]{100001, 100002, 100003}, 1));           //200005
        // System.out.println(obj.eaten(100, new int[]{1000, 2000}, 7));                       //3000

        // System.out.println(obj.eaten(1234, new int[]{10, 20, 30, 40}, 0));                   //100
        // System.out.println(obj.eaten(1234, new int[]{10, 20, 30, 40}, 2));                   //100
        // System.out.println(obj.eaten(1000, new int[]{1000, 999, 999}, 0));                   //1999
        System.out.println(obj.eaten(50, new int[]{49, 82, 1, 14, 42}, 1));       //174
    }
}
