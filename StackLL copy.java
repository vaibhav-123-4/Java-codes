class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class Stack{
    Node head;
    int size;
    Stack(){
        this.head = null;
        this.size = 0;
    }
    void push(int data){
        Node new_node = new Node(data);
        if(this.head == null){
            this.head = new_node;
        }
        else{
            new_node.next = this.head;
            this.head = new_node;
        }
        this.size++;
    }
    void pop(){
        if(this.head == null){
            System.out.println("Stack is empty");
        }
        else{
            this.head = this.head.next;
            this.size--;
        }
    }
    void display(){
        Node temp = this.head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
public class StackLL{
    public static void main(String[] args){
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.display();
        s.pop();
        s.display(); 
    }
}
