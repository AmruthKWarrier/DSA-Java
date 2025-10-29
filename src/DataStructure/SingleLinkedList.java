package DataStructure;

public class SingleLinkedList {
    int data;
    SingleLinkedList next;

    public SingleLinkedList(int data){
        this.data = data;
        this.next= null;
    }

    public void addNode(int data){
        SingleLinkedList node= new SingleLinkedList(data);
        SingleLinkedList temp = this;
        while(temp.next != null){
            temp=temp.next;
        }
        temp.next = node;
        //return head;
    }

    public void printList(){
        SingleLinkedList temp = this;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }

    public SingleLinkedList removeLastNode(){
        SingleLinkedList temp = this;
        while (temp.next.next!=null){
            temp = temp.next;
        }
        SingleLinkedList deletedNode = temp.next;
        temp.next=null;
        return deletedNode;
    }

    public SingleLinkedList removeNthNode(int n){
        if(n<0) return null;
        if(n==0) return this.next;

        SingleLinkedList temp = this;
        while(n>1 && temp.next!=null){
            temp=temp.next;
            n--;
        }
        if(temp.next==null){
            return null;
        }
        SingleLinkedList deletedNode = temp.next;
        temp.next = temp.next.next;
        deletedNode.next=null;
        return deletedNode;
    }

    public SingleLinkedList removeHead(){
        return this.next;
    }

    public SingleLinkedList reverseList(){
        SingleLinkedList curr = this;
        SingleLinkedList next;
        SingleLinkedList prev = null;

        while (curr!=null){
            next=curr.next;
            curr.next=prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static void main(String[] args) {
        SingleLinkedList node = new SingleLinkedList(1);
        node.addNode(2);
        node.addNode(3);
        node.addNode(4);
        node.addNode(5);
        node.addNode(6);
//        node.printList();
//        node.removeNthNode(7);
//        System.out.println("after delete");
//        node.printList();
//        System.out.println("new head");
//        SingleLinkedList newHead = node.removeHead();
//        newHead.printList();
        SingleLinkedList newNode =node.reverseList();
        newNode.printList();
    }
}
