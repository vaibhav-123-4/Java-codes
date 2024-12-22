class ArrayList<T extends Comparable<T>> {
    Object[] arr;
    int size;
    int capacity;

    ArrayList() {
        capacity = 8;
        size = 0;
        arr = new Object[capacity];
    }

    ArrayList(int cap) {
        capacity = cap;
        size = 0;
        arr = new Object[capacity];
    }

    void increaseSize() {
        capacity *= 2;
        Object[] tempArr = new Object[capacity];
        for (int i = 0; i < size; i++) {
            tempArr[i] = arr[i];
        }
        arr = tempArr;
    }

    void add(T item) {
        if (size == capacity) {
            increaseSize();
        }
        arr[size++] = item;
    }

    void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == capacity) {
            increaseSize();
        }
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = item;
        size++;
    }

    void push(T item) {
        if (size == capacity) {
            increaseSize();
        }
        for (int i = size; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = item;
        size++;
    }

    void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    void pop() {
        size--;
    }

    void shiftBack() {
        remove(0);
    }

    void removeItem(T item) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(item)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            remove(index);
        } else {
            throw new IllegalArgumentException("Item not found");
        }
    }

    T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) arr[index];
    }

    int size() {
        return size;
    }

    int indexOf(T item) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    boolean contains(T item) {
        return indexOf(item) != -1;
    }

    void set(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        arr[index] = item;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int capacity() {
        return capacity;
    }

    void clear() {
        size = 0;
    }

    void sort() {
        for (int i = 1; i < size; i++) {
            T a = (T) arr[i];
            int j = i - 1;
            while (j >= 0 && ((Comparable<T>) arr[j]).compareTo(a) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = a;
        }
    }
}

public class lab01 {
    static void printArray(ArrayList<Integer> arr) {
        System.out.print("Array:");
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(" " + arr.get(i));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < 12; i++) {
            arr.add(i);
        }
        printArray(arr);
        arr.add(13, 100);
        System.out.println("Size: " + arr.size());
        System.out.println("Capacity: " + arr.capacity());
        arr.push(100);
        arr.remove(2);
        printArray(arr);
        arr.pop();
        arr.shiftBack();
        arr.removeItem(8);
        arr.set(2, 1000);
        printArray(arr);
        System.out.println("Item at index 2: " + arr.get(2));
        if (arr.contains(1000)) {
            System.out.println("1000 is present at index: " + arr.indexOf(1000));
        }
        System.out.println("Size: " + arr.size());
        System.out.println("Capacity: " + arr.capacity());
        System.out.println("Is empty: " + arr.isEmpty());
        arr.sort();
        printArray(arr);
        arr.clear();
        System.out.println("Size: " + arr.size());
        System.out.println("Is empty: " + arr.isEmpty());
    }
}
