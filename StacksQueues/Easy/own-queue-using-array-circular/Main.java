class Queue {
    int[] arr;
    int size;
    int curSize;
    int front;
    int rear;

    public Queue(int size) {
        front = -1;
        rear = -1;
        arr = new int[size];
        curSize = 0;
        this.size = size;
    }

    public void push(int x) {
        if (rear == -1) {
            front = 0;
            rear = 0;
        }
        if (curSize == size) {
            System.out.println("Queue is full!");
            return;
        }
        curSize++;
        arr[rear] = x;
        rear = (rear + 1) % size;
    }

    public int poll() {
        if (curSize == 0) {
            return -1;
        }
        curSize--;
        int num = arr[front]; 
        front = (front + 1) % size;
        return num;
    }
}

public class Main {
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.push(1);
        q.push(2);
        q.push(3);
        System.out.println(q.poll());
        System.out.println(q.poll());
    }
}
