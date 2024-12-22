
    

class Node<T> {
    T data;
    Node<T> next;
    Node<T> prev;

    Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class LinkedList<T> {
    Node<T> head;
    private int size;

    LinkedList() {
        this.head = null;
        this.size = 0;
    }

    void add(int index, T data) {
        if (index < 0 || index > size) {
            System.out.println("Invalid index");
        } else {
            Node<T> newNode = new Node<T>(data);
            if (index == 0) {
                newNode.next = head;
                if (head != null) {
                    head.prev = newNode;
                }
                head = newNode;
            } else {
                Node<T> temp = head;
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.next;
                }
                newNode.next = temp.next;
                if (temp.next != null) {
                    temp.next.prev = newNode;
                }
                temp.next = newNode;
                newNode.prev = temp;
            }
            size++;
        }
    }

    void add(T data) {
        add(size, data);
    }

    void pushIn(T data) {
        add(0, data);
    }

    void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index");
        } else {
            if (index == 0) {
                head = head.next;
                if (head != null) {
                    head.prev = null;
                }
            } else {
                Node<T> temp = head;
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.next;
                }
                temp.next.prev = null;
                temp.next = temp.next.next;
                if (temp.next != null) {
                    temp.next.prev.next = null;
                    temp.next.prev = temp;
                }
            }
            size--;
        }
    }

    void pop() {
        remove(size - 1);
    }

    void shiftBack() {
        remove(0);
    }

    void removeElement(T data) {
        Node<T> temp = head;
        if (temp.data == data) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            size--;
        } else {
            while (temp.next != null) {
                if (temp.next.data == data) {
                    temp.next = temp.next.next;
                    if (temp.next != null) {
                        temp.next.prev = temp;
                    }
                    size--;
                    return;
                }
                temp = temp.next;
            }
        }
    }

    void clear() {
        head = null;
        size = 0;
    }

    int getSize() {
        return size;
    }

    void print() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class ImplementDoubleLinkedList {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<String>();
        names.add("Devyash");
        names.add("Sourabh");
        names.pushIn("Anas");
        names.add(1, "Deepanshu");
        names.print();
        System.out.println(names.getSize());
        names.print();
    }
}
