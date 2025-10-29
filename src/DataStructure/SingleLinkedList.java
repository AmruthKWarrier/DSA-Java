package DataStructure;

public class SingleLinkedList {
    private Node head;

    // Constructor: create an empty list
    public SingleLinkedList() {
        this.head = null;
    }

    // Constructor: create a list with one node
    public SingleLinkedList(int data) {
        this.head = new Node(data);
    }

    // Add a new node at the end
    public void addNode(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Print all nodes
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    // Remove the last node and return it
    public Node removeLastNode() {
        if (head == null) return null;
        if (head.next == null) {
            Node deleted = head;
            head = null;
            return deleted;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        Node deletedNode = temp.next;
        temp.next = null;
        return deletedNode;
    }

    // Remove nth node (0-based index)
    public Node removeNthNode(int n) {
        if (n < 0 || head == null) return null;

        if (n == 0) {
            Node deleted = head;
            head = head.next;
            deleted.next = null;
            return deleted;
        }

        Node temp = head;
        for (int i = 0; i < n - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        if (temp.next == null) return null;

        Node deleted = temp.next;
        temp.next = temp.next.next;
        deleted.next = null;
        return deleted;
    }

    // Remove head node
    public Node removeHead() {
        if (head == null) return null;

        Node deleted = head;
        head = head.next;
        deleted.next = null;
        return deleted;
    }

    // Reverse the list
    public void reverseList() {
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    // Get head (optional, for testing)
    public Node getHead() {
        return head;
    }

    // Main method for testing
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        list.addNode(6);

        System.out.println("Original List:");
        list.printList();

        System.out.println("\nAfter Reversing:");
        list.reverseList();
        list.printList();

        System.out.println("\nRemoved Last Node: " + list.removeLastNode().data);
        System.out.println("List After Removing Last:");
        list.printList();

        System.out.println("\nRemoved 2nd Node (index 1): " + list.removeNthNode(1).data);
        list.printList();

        System.out.println("\nRemoved Head Node: " + list.removeHead().data);
        list.printList();
    }
}