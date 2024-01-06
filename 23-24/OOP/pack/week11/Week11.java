import java.util.List;

public class Week11<T> {
    /**
     * ok.
     */
    public static <T extends Comparable<T>> List<T> sortGeneric(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                T current = list.get(i);
                T next = list.get(j);
                if (current.compareTo(next) > 0) {
                    list.set(i, next);
                    list.set(j, current);
                }
            }
        }
        return list;
    }
}