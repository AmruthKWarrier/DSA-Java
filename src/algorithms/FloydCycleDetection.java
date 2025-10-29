package algorithms;
import DataStructure.*;
public class FloydCycleDetection {
    public boolean detectCycle(Node head){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next!=null){
            slow = slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        SingleLinkedList list = new SingleLinkedList(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        list.addNode(6);

        Node head = list.getHead();

        // No cycle
        FloydCycleDetection detector = new FloydCycleDetection();
        System.out.println("Cycle detected (should be false): " + detector.detectCycle(head));

        //  Create a cycle manually (6 -> 3)
        Node temp = head;
        Node third = null;
        while (temp.next != null) {
            if (temp.data == 3) {
                third = temp;
            }
            temp = temp.next;
        }
        // temp is now at node 6
        temp.next = third;  // Create a cycle: 6 -> 3

        System.out.println("Cycle detected (should be true): " + detector.detectCycle(head));
    }
}
