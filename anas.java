class ArrayList<T> {
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

    void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
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

   
}


class anas{
    int binarySearch(ArrayList<Integer> arr, int x) {
        int l = 0, r = arr.size() - 1;
        while(l <= r){
            int m = l + (r - l) / 2;
            if (arr.get(m) == x)
                return m;
            if (arr.get(m) < x)
                l = m + 1;
            else
                r = m - 1;
        }
        return l;
    }

    static void printArray(ArrayList<Integer> arr) {
        System.out.print("Array:");
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(" " + arr.get(i));
        }
        System.out.println();
    }
    public static void main(String[] args) {
        anas obj = new anas();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int x = 5;
        arr.add(obj.binarySearch(arr, x), x);
        x = 9;
        arr.add(obj.binarySearch(arr, x), x);
        x = 3;
        arr.add(obj.binarySearch(arr, x), x);
        x = 5;
        arr.add(obj.binarySearch(arr, x), x);
        printArray(arr);
}
}
