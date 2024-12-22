
    




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
      Node reverse_linkedlist(Node head){
        Node prev = null;
        Node current = head;        
        Node next = null;
        while(current != null){
            next = current.Next;
            current.Next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;

      }
      Object middle_element(){
        Node one = this.head;
        Node two = this.head;
        while(two != null && two.Next != null ){
            one = one.Next;
            two = two.Next.Next;
        }
        return one.data;

      }

                }

public class reverseLList{
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
       MyLinkedlist.head = MyLinkedlist.reverse_linkedlist(MyLinkedlist.head);
       printlist(MyLinkedlist);
       System.out.println("Mid = "+MyLinkedlist.middle_element());
    }

}