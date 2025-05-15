package del.alstrudat;

import java.util.Comparator;

public class LinkedListHelper {
    
    public static <T> void sortList(LinkedList<T> list, Comparator<T> comparator) {
        // Simple bubble sort implementation for linked list
        int n = list.size();
        if (n <= 1) {
            return;
        }
        
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                T current = list.get(j);
                T next = list.get(j + 1);
                
                if (comparator.compare(current, next) > 0) {
                    // Swap
                    list.set(j, next);
                    list.set(j + 1, current);
                    swapped = true;
                }
            }
            
            // If no swapping occurred in this pass, the list is sorted
            if (!swapped) {
                break;
            }
        }
    }
}
