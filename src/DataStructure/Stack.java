package DataStructure;

public class Stack {
    //this stack stores only integers
    public int top;
    private int[] stack;
    int size;
    public Stack(int size){
        stack = new int[size];
        this.top=-1;
        this.size=size;
    }

    public void push(int n){
        if (top >=size-1){
            System.out.println("Stack Overflow");
        }
        else {stack[++top] = n;
        }
    }

    public int pop(){
        if(top<=0){
            System.out.println("Stack is empty");
        }
        return stack[top--];
    }

    public int peek(){
        return stack[top];
    }

    public static void main(String[] args) {
        Stack stack = new Stack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(1);
        System.out.println( stack.peek());
        stack.pop();
        System.out.println( stack.peek());
        stack.pop();
        System.out.println( stack.peek());
        stack.pop();
        stack.pop();
    }
}
