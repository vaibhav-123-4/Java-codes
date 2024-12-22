class treenode {
    int data;
    treenode left;
    treenode right;
    treenode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
} 
class binarytree{
    treenode root;
    binarytree(int data){
        this.root = new treenode(data);
    }
    binarytree(){
        this.root = null;
    }
    void printinorder(treenode node){
        if(node==null){
            return;
        }
        printinorder(node.left);
        System.out.print(node.data+" ");
        printinorder(node.right);
    }
    void printpreorder(treenode node){
        if(node==null){
            return;
        }
        System.out.print(node.data+" ");
        printpreorder(node.left);
        printpreorder(node.right);
    }
    void printpostorder(treenode node){
        if(node==null){
            return;
        }
        printpostorder(node.left);
        printpostorder(node.right);
        System.out.print(node.data+" ");
    }
}