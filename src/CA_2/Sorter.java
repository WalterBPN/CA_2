package CA_2;

import java.util.ArrayList;
import java.util.List;

// Sort utilities using recursive Merge Sort (A - Z, case-insensitive)
// Called by Main in the SORT and SEARCH options of the Employee Management System
public class Sorter {

    /*
        - Returns a new list with Employees sorted by name (A - Z, case-insensitive)
        - Does not modify the original source list; call with a copy if needed
        - Used when sorting in-memory company employees from DataStore
    */
    public List<Employee> mergeSortByName(List<Employee> source) {
        if (source == null || source.size() <= 1) {
            return source;
        }

        int mid = source.size() / 2;
        List<Employee> leftHalf  = new ArrayList<>(source.subList(0, mid));
        List<Employee> rightHalf = new ArrayList<>(source.subList(mid, source.size()));

        // Recursively sort each half
        leftHalf  = mergeSortByName(leftHalf);
        rightHalf = mergeSortByName(rightHalf);

        // Merge two sorted halves
        return mergeEmployeesByName(leftHalf, rightHalf);
    }

    /*
        - Merges two sorted lists of Employees by name (A - Z, case-insensitive)
        - Used internally by mergeSortByName
    */
    private List<Employee> mergeEmployeesByName(List<Employee> left, List<Employee> right) {
        List<Employee> result = new ArrayList<>(left.size() + right.size());
        int leftIndex = 0;
        int rightIndex = 0;

        // Compare current names from both lists and append the smaller one (alphabetically)
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

    /*
        - Returns a new list with applicant names (Strings) sorted (A - Z, case-insensitive)
        - Does not modify the original source list; call with a copy if needed
        - Used in SORT and SEARCH for the applicants read from the TXT file
    */
    public List<String> mergeSortStrings(List<String> source) {
        if (source == null || source.size() <= 1) {
            return source;
        }

        int mid = source.size() / 2;
        List<String> leftHalf  = new ArrayList<>(source.subList(0, mid));
        List<String> rightHalf = new ArrayList<>(source.subList(mid, source.size()));

        // Recursively sort each half
        leftHalf  = mergeSortStrings(leftHalf);
        rightHalf = mergeSortStrings(rightHalf);

        // Merge two sorted halves
        return mergeStrings(leftHalf, rightHalf);
    }

    /*
        - Merges two sorted lists of Strings (A - Z, case-insensitive)
        - Used internally by mergeSortStrings
    */
    private List<String> mergeStrings(List<String> left, List<String> right) {
        List<String> result = new ArrayList<>(left.size() + right.size());
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            String leftValue  = (left.get(leftIndex)  == null) ? "" : left.get(leftIndex).toLowerCase();
            String rightValue = (right.get(rightIndex) == null) ? "" : right.get(rightIndex).toLowerCase();

            if (leftValue.compareTo(rightValue) <= 0) {
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
