class Queue_ArrayList {
    int[] arr;
    int front;
    int rear;
    int capacity;

    Queue_ArrayList(int cap) {
        capacity = cap;
        arr = new int[capacity];
        front = 0;
        rear = 0;
    }

 void addInqueue(int data) {
        if (rear == capacity) {
           System.out.println("queue is full");
        }
        arr[rear++] = data;
    }

    int removeElement() {
        if (front == rear) {
           System.out.println("queue is empty");
        }
        return arr[front++];
    }

    int peek() {
        if (front == rear) {
            System.out.println("queue is empty");
        }
        return arr[front];
    }
int size() {
        return rear - front;
    }
boolean isEmpty() {
        return front == rear;
    }
}

public class queue {
    public static void main(String[] args) {
        Queue_ArrayList q = new Queue_ArrayList(10);
        for (int i = 3; i < 12; i += 2)
            q.addInqueue(i);
        System.out.println(q.removeElement());
        System.out.println(q.peek());
        System.out.println(q.size());
    }
}

