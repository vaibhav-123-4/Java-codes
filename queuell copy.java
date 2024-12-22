class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
class Queuelinkedlist{
    Node front;
    int size;
    LinkedList list = new LinkedList();
    Queuelinkedlist(){
        this.front = null;
        this.size = 0;
    }
    void addInqueue(int data){
        Node new_node = new Node(data);
        if(this.front == null){
            this.front = new_node;
        }
        else{
            Node temp = this.front;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new_node;
        }
        this.size++;
    }
    void removeElement(){
        if(this.front == null){
            System.out.println("Queue is empty");
        }
        else{
            this.front = this.front.next;
            this.size--;
        }
    }

    void print(){
        Node temp = this.front;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class queuell{
    public static void main(String[] args){
        Queuelinkedlist q = new Queuelinkedlist();
        
        q.addInqueue(1);
        q.addInqueue(10);
        q.addInqueue(100);
        q.addInqueue(1000);
        q.print();
        q.removeElement();
        q.print();
 }
}
