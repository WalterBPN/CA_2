package CA_2;

import java.util.List;

// Performs Binary Search on a sorted list of applicant names (Strings)
// Called by Main in the SEARCH option after sorting the names with Merge Sort
public class Searcher {

    // Searches for a given full name inside a sorted list of names.
    // Returns the index of the match, or -1 if the name is not found.
    // The comparison is case-insensitive to make user input more flexible.
    public int binarySearchByName(List<String> sortedNames, String target) {

        if (sortedNames == null || sortedNames.isEmpty()) {
            return -1;
        }
        if (target == null || target.trim().isEmpty()) {
            return -1;
        }

        String key = target.toLowerCase();
        int low = 0;
        int high = sortedNames.size() - 1;

        // Classic binary search algorithm
        while (low <= high) {
            int mid = (low + high) / 2;

            String midValue = sortedNames.get(mid);
            String midLower = (midValue == null) ? "" : midValue.toLowerCase();

            int comparison = midLower.compareTo(key);

            if (comparison == 0) {
                return mid;   // Found the name
            }
            if (comparison < 0) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }

        return -1; // Not found
    }
}
