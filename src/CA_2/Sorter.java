package CA_2;

import java.util.ArrayList;
import java.util.List;

// Sorts employees by name (A - Z, case-insensitive) using recursive Merge Sort

public class Sorter {

    /*
        - Returns a new list with employees sorted by name (ascending and case-insensitive)
        - Does not modify the original source list, call with a copy if needed
    */
    public List<Employee> mergeSortByName(List<Employee> source) {
        if (source == null || source.size() <= 1) return source;

        int mid = source.size() / 2;
        List<Employee> leftHalf  = new ArrayList<>(source.subList(0, mid));
        List<Employee> rightHalf = new ArrayList<>(source.subList(mid, source.size()));

        // Recursively sort each half
        leftHalf  = mergeSortByName(leftHalf);
        rightHalf = mergeSortByName(rightHalf);

        // Merge two sorted halves
        return mergeByName(leftHalf, rightHalf);
    }

    /*
        - Merges two sorted lists of employees by name (A - Z, case-insensitive)
        - Used internally by mergeSortByName
    */
    private List<Employee> mergeByName(List<Employee> left, List<Employee> right) {
        List<Employee> result = new ArrayList<>(left.size() + right.size());
        int leftIndex = 0;
        int rightIndex = 0;

        // Compare current names from both lists and append the smaller (alphabetically)
        while (leftIndex < left.size() && rightIndex < right.size()) {
            String leftName = left.get(leftIndex).getName();
            String rightName = right.get(rightIndex).getName();

            String leftNameLower = (leftName == null) ? "" : leftName.toLowerCase();
            String rightNameLower = (rightName == null) ? "" : rightName.toLowerCase();

            if (leftNameLower.compareTo(rightNameLower) <= 0) {
                result.add(left.get(leftIndex++));
            } else {
                result.add(right.get(rightIndex++));
            }
        }

        // Append remaining elements (if any)
        while (leftIndex < left.size()) {
            result.add(left.get(leftIndex++));
        }
        while (rightIndex < right.size()) {
            result.add(right.get(rightIndex++));
        }

        return result;
    }
}
