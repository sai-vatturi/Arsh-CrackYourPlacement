import java.util.Stack;

class MyQueue {
    /*
        For implementing Queue using Stacks, Remember this:

        Use two stacks named exactly as INPUT and OUTPUT
        
        Push:
            Directly push to INPUT stack
        Pop:
            if OUTPUT is empty,
                push all elements in input to output
            pop and return top most element of output
        Peek:
             if OUTPUT is empty,
                push all elements in input to output
            peek and return top most element of output
        Empty:
            check if both stack1 and stack2 are empty

    */
    Stack<Integer> input;
    Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();    
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        if (output.isEmpty()) {
            if (input.isEmpty()) {
                return -1;
            }
            else {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
        }
        return output.pop();
    }
    
    public int peek() {
        if (output.isEmpty()) {
            if (input.isEmpty()) {
                return -1;
            }
            else {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
        }
        return output.peek();
    }
    
    public boolean empty() {
        return (input.isEmpty() && output.isEmpty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */