class maxheap{
    int[] heap;
    int size;
    int maxsize;
    maxheap(int maxsize){
        this.maxsize = maxsize;
        this.size = 0;
        heap = new int[this.maxsize+1];
        heap[0] = Integer.MAX_VALUE;
    }
    public void heapify_up(){
        int k = size;
        while(k>0 && heap[k]>heap[k/2]){
            int temp = heap[k];
            heap[k] = heap[k/2];
            heap[k/2] = temp;
            k = k/2;
        }
    }
    public void insert(int val){
        heap[++size] = val;

        
        heapify_up();
    }
    public void heapify_down(int index){
        int left_child = 2*index;
        int right_child = 2*index+1;
        int largest = index;
        if(left_child<=size && heap[left_child]>heap[index]){
            largest = left_child;
        }
        if(right_child<=size && heap[right_child]>heap[largest]){
            largest = right_child;
        }
        if(largest!=index){
            int temp = heap[index];
            heap[index] = heap[largest];
            heap[largest] = temp;
            heapify_down(largest);
        }
    }
    public int delete_root(){
        int maxval = heap[1];
        heap[1] = heap[size--];
        heapify_down(1);
        return maxval;
    }

    public void print(){
        for(int i=1;i<=size/2;i++){
            System.out.print(" PARENT : "+heap[i]+" LEFT CHILD : "+heap[2*i]+" RIGHT CHILD : "+heap[2*i+1]);
            System.out.println();
        }
    }

    public static void main(String[] args){
        maxheap heap = new maxheap(15);
        heap.insert(5);
        heap.insert(3);
        heap.insert(17);
        heap.insert(10);
        heap.insert(84);
        heap.insert(19);
        heap.insert(6);
        heap.insert(22);
        heap.insert(9);
        heap.print();
        System.out.println("The max val is: "+heap.delete_root());
    }
}