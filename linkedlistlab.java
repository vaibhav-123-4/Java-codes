
class Node{
    Object data;
    Node Next;
    Node(Object data){
        this.data=data;
        this.Next=null;
    }
}

class LinkedList{
    Node head;
    int size;
    LinkedList(){
        this.head=null;
        this.size=0;
    }
    
    void insert_last(Object data){
        Node newNode = new Node(data);
        if(this.head == null){
            this.head = newNode;
        }else{
            Node temp = this.head;
            while(temp.Next != null){
                temp = temp.Next;
            }
            temp.Next = newNode;
        }
        this.size++ ;
    }
    void insert_pos(int pos, Object data){
        if(pos < 0 || pos > this.size){
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node(data);
        if(pos == 0){
            newNode.Next = this.head;
            this.head = newNode;
        }else{
            Node temp = this.head;
            for(int i = 0; i < pos - 1; i++){
                temp = temp.Next;
            }
            newNode.Next = temp.Next;
            temp.Next = newNode;
        }
        this.size++;
      }

                }

public class linkedlistlab{
    static void printlist(LinkedList MyLinkedlist){
        Node temp  = MyLinkedlist.head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.Next;
        }
        }
    
    public static void main(String[] args) {
       
       LinkedList MyLinkedlist = new LinkedList();
       MyLinkedlist.insert_last(5);
       MyLinkedlist.insert_last(15);
       MyLinkedlist.insert_last(56);
       MyLinkedlist.insert_last(10);
       MyLinkedlist.insert_last(45);
       MyLinkedlist.insert_pos(2, 12);
       printlist(MyLinkedlist);
    }
}
    

// }
// class Node<T> {
//     T data;
//     Node<T> next;
    
//     Node(T data) {
//         this.data = data;
//         this.next = null;
//     }
// }

// class LinkedList<T> {
//     Node<T> head;
//     private int size;

//     LinkedList() {
//         this.head = null;
//         this.size = 0;
//     }

//     void add(int index, T data) {
//         if (index < 0 || index > size) {
//             System.out.println("Invalid index");
//         } else {
//             Node<T> newNode = new Node<T>(data);
//             if (index == 0) {
//                 newNode.next = head;
//                 head = newNode;
//             } else {
//                 Node<T> temp = head;
//                 for (int i = 0; i < index - 1; i++) {
//                     temp = temp.next;
//                 }
//                 newNode.next = temp.next;
//                 temp.next = newNode;
//             }
//             size++;
//         }
//     }

//     void add(T data) {
//         add(size, data);
//     }

//     void pushIn(T data) {
//         add(0, data);
//     }

//     void remove(int index) {
//         if (index < 0 || index >= size) {
//             System.out.println("Invalid index");
//         } else {
//             if (index == 0) {
//                 head = head.next;
//             } else {
//                 Node<T> temp = head;
//                 for (int i = 0; i < index - 1; i++) {
//                     temp = temp.next;
//                 }
//                 temp.next = temp.next.next;
//             }
//             size--;
//         }
//     }

//     void pop() {
//         remove(size - 1);
//     }

//     void shiftBack() {
//         remove(0);
//     }

//     void removeElement(T data) {
//         Node<T> temp = head;
//         if (temp.data == data) {
//             head = head.next;
//             size--;
//         } else {
//             while (temp.next != null) {
//                 if (temp.next.data == data) {
//                     temp.next = temp.next.next;
//                     size--;
//                     break;
//                 }
//                 temp = temp.next;
//             }
//         }
//     }

//     void clear() {
//         head = null;
//         size = 0;
//     }

//     void print() {
//         Node<T> temp = head;
//         while (temp != null) {
//             System.out.print(temp.data + " ");
//             temp = temp.next;
//         }
//         System.out.println();
//     }

//     int getSize() {
//         return size;
//     }

//     void reverse() {
//         Node<T> prev = null;
//         Node<T> current = head;
//         Node<T> next = null;
//         while (current != null) {
//             next = current.next;
//             current.next = prev;
//             prev = current;
//             current = next;
//         }
//         head = prev;
//     }
// }

// public class linkedlistlab {
//     public static void main(String[] args) {
//         LinkedList<String> names = new LinkedList<String>();
//         names.add("Devyash");
//         names.add("Sourabh");
//         names.pushIn("Anas");
//         names.add(1,"Deepanshu");
//         names.print();
//         System.out.println(names.getSize());
//         names.reverse();
//         names.print();
//     }
// }