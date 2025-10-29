package DataStructure;

public class Queue {
    private int front;
    private int rear;
    private int size;
    private int[] queue;

    public Queue(int size) {
        this.size = size;
        this.queue = new int[size];
        this.front = -1;
        this.rear = -1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Queue is full - cannot push " + data);
            return;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % size;
        }
        queue[rear] = data;
        System.out.println("Pushed: " + data);
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Queue is empty - cannot pop");
            return -1;
        }
        int popped = queue[front];
        if (front == rear) {
            // Queue becomes empty after this pop
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }
        System.out.println("Popped: " + popped);
        return popped;
    }

    public void peek() {
        System.out.println("Front index: " + front + ", Rear index: " + rear);
        if (!isEmpty()) {
            System.out.println("Front value: " + queue[front] + ", Rear value: " + queue[rear]);
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(3);
        q.peek();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4); // should print full
        q.peek();
        q.pop();
        q.pop();
        q.push(4);
        q.push(5); // now should wrap around
        q.peek();
        q.pop();
        q.pop();
        q.pop();
        q.pop(); // empty
        q.peek();
    }
}
