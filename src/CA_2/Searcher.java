package CA_2;

import java.util.List;

// Performs Binary Search on a sorted list of applicant names (Strings)
// Called by Main in the SEARCH option
public class Searcher {

    // Returns the index if found; -1 otherwise (case-insensitive)
    public int binarySearchByName(List<String> sortedNames, String target) {
        if (sortedNames == null || sortedNames.isEmpty()) return -1;
        if (target == null || target.trim().isEmpty()) return -1;

        String key = target.toLowerCase();
        int low = 0, high = sortedNames.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            String midVal = sortedNames.get(mid) == null ? "" : sortedNames.get(mid).toLowerCase();

            int cmp = midVal.compareTo(key);
            if (cmp == 0) return mid;        // found
            if (cmp < 0)  low = mid + 1;     // search right
            else          high = mid - 1;    // search left
        }
        return -1; // not found
    }
}
