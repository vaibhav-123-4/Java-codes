class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
class circular_list{
    Node head = null;
    int size;
    circular_list(){
        head = null;
        size=0;
    }
    void addAtlast(int data){
        Node new_node = new Node(data);
        if(head==null){
            head=new_node;
            head.next = head;
        }
        else{
            Node temp = head;
            while(temp.next != head){
                temp = temp.next;
            }
            temp.next = new_node;
            new_node.next = head;

        }
    }
    void addAtindex(int data,int index){
        Node new_node = new Node(data);
        if(index<0 || index>size){
            System.out.println("index out of range");
            return;
        }
        if(head==null){
            head = new_node;
            head.next = head;
        }
        else if(index==0){
            new_node.next=head;
            Node temp=head;
            while(temp.next!=head){
                temp=temp.next;
            }
            temp.next=new_node;
            head=new_node;
            }
            else{
                Node temp=head;
                for(int i=0;i<index;i++){
                    temp=temp.next;
                }
                new_node.next=temp.next;
                temp.next=new_node;
            }
        }
        void delete(int data,int index){
            if(index==0){
                Node temp=head;
                while(temp.next!=head){
                    temp=temp.next;
                }
                temp.next=head.next;
                head=head.next;
            }
            else{
                Node temp=head;
                for(int i=0;i<index-1;i++){
                    temp=temp.next;
                }
                temp.next=temp.next.next;
            }
            this.size--;
            }
        void print(){

            
            Node temp = head;
            do{
                System.out.println(temp.data + " ");
                temp=temp.next;
            }
            while(temp!=head);
            }
        }
    

public class circularllist {
    public static void main(String[] args) {
        circular_list object = new circular_list();
        for(int i=0;i<5;i++){
            object.addAtlast(i);
        }
        object.print();
        System.out.println();
        object.addAtindex(5,0);
        object.print();
        System.out.println();
        object.delete(6,3);
        object.print();
        return;
    }

    }
    

