import java.util.ArrayList;

public class SortedList {
    private ArrayList<String> list;

    public SortedList() {
        list = new ArrayList<>();
    }

    public void add(String element) {
        int position = binarySearchInsertPosition(element);
        list.add(position, element);
    }

    public int binarySearchInsertPosition(String element) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = list.get(mid).compareTo(element);

            if (comparison == 0) {
                return mid; // Exact match
            } else if (comparison < 0) {
                left = mid + 1; // Move to the right
            } else {
                right = mid - 1; // Move to the left
            }
        }

        return left; // Position where the element should be inserted
    }

    public String search(String element) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = list.get(mid).compareTo(element);

            if (comparison == 0) {
                return "Element found: " + list.get(mid) + " at index " + mid;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return "Element not found. Should be inserted at index: " + left;
    }

    public String getAllElements() {
        return list.toString();
    }
}
