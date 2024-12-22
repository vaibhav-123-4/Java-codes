import java.util.Arrays;

public class OrderedArrayList<T extends Comparable<T>> {
    private Object[] elements;
    private int count;
    private static final int DEFAULT_CAPACITY = 10;

    public OrderedArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.count = 0;
    }

    public void add(T item) {
        if (count == elements.length)
            increaseCapacity();

        int index = Arrays.binarySearch(elements, 0, count, item);

        if (index < 0)
            index = -(index + 1);

        // Ensure the array remains sorted after insertion
        System.arraycopy(elements, index, elements, index + 1, count - index);
        elements[index] = item;
        count++;
    }

    public void remove(T item) {
        int index = Arrays.binarySearch(elements, 0, count, item);

        if (index >= 0) {
            System.arraycopy(elements, index + 1, elements, index, count - index - 1);
            count--;
        }
    }

    public void removeAtIndex(int index) {
        if (index >= 0 && index < count) {
            System.arraycopy(elements, index + 1, elements, index, count - index - 1);
            count--;
        }
    }

    public boolean contains(T item) {
        return Arrays.binarySearch(elements, 0, count, item) >= 0;
    }

    public int size() {
        return count;
    }

    private void increaseCapacity() {
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    public int binarySearch(T key) {
        if (count == 0) return -1; // Handle empty array case
        return binarySearch(key, 0, count - 1);
    }

    private int binarySearch(T key, int low, int high) {
        if (high < low)
            return -(low + 1);

        int mid = low + (high - low) / 2;
        Comparable<T> midVal = (Comparable<T>) elements[mid];

        int cmp = midVal.compareTo(key);

        if (cmp < 0)
            return binarySearch(key, mid + 1, high);
        else if (cmp > 0)
            return binarySearch(key, low, mid - 1);
        else
            return mid;
    }

    public void display() {
        for (int i = 0; i < count; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        OrderedArrayList<Integer> list = new OrderedArrayList<>();
        list.add(5);
        list.add(2);
        list.add(7);
        list.add(3);
        list.add(1);

        System.out.println("Array size: " + list.size());
        System.out.println("Binary search for 5: " + list.binarySearch(5));

        System.out.println("Removing element 3");
        list.remove(3);
        System.out.println("Array size after removal: " + list.size());

        System.out.println("Contains element 7: " + list.contains(7));

        System.out.println("Removing element at index 1");
        list.removeAtIndex(1);
        System.out.println("Array size after removal: " + list.size());

        System.out.println("Displaying elements:");
        list.display();
    }
}
