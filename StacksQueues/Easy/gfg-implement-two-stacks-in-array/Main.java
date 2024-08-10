class twoStacks {
    /*
    The best approach here is to use starting and ending of the array to represent two stacks
    */
    int[] arr;
    int top1;
    int top2;
    int size;
    int count;
    
    twoStacks() {
        size = 200;
        arr = new int[size];
        top1 = -1;
        top2 = size;
        count = 0;
    }

    void push1(int x) {
        if (count > size) {
            return;
        }
        arr[++top1] = x;
    }

    void push2(int x) {
        if (count > size) {
            return;
        }
        arr[--top2] = x;
    }


    int pop1() {
        if (top1 == -1) {
            return -1;
        } 
        return arr[top1--];
    }

    int pop2() {
        if (top2 == size) {
            return -1;
        }
        return arr[top2++];
    }
}