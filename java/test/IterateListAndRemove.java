package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author fouthed
 * @date 2023/5/24
 */
public class IterateListAndRemove {

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(1);
        l.add(1);
        l.add(1);
        l.add(1);
        System.out.println(Arrays.toString(l.toArray()));
        Iterator<Integer> i = l.iterator();
        while (i.hasNext()) {
            Integer b = i.next();
            i.remove();
        }
        System.out.println(Arrays.toString(l.toArray()));
        l.add(1);
        l.add(1);
        l.add(1);
        l.add(1);
        l.add(1);
        for (int z = 0; z < l.size(); z++) {
            l.removeIf(m -> m == 1);
        }
        System.out.println(Arrays.toString(l.toArray()));
    }
}
