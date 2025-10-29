package DataStructure;

public class Node {
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
        this.next=null;
    }
    public Node(Node node){
        this.data = node.data;
        this.next=node.next;
    }
}
