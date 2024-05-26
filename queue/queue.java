package queue;
import java.util.Arrays;

public class queue {
    int[] Q;
    int front, rear;

    public queue(int length) {
        Q = new int[length];
        front = rear = 0;
    }

    public queue() {
        Q = new int[10];
        front = rear = 0;
    }

    public void enqueue(int x) {
        if (front == ((rear+1)%Q.length)) {
            System.out.println("Queue is Full");
        }
        Q[rear] = x;
        rear = (rear+1)%Q.length;
    }

    public void dequeue() {
        if (front == rear) {
            System.out.println("Queue is Empty");
            return;
        }
        front=(front+1)%Q.length;
    }
    public static void main(String[] args) {
        queue q = new queue();
        q.enqueue(0);
        q.enqueue(2);
        q.enqueue(5);
        q.enqueue(10);
        System.out.println(Arrays.toString(q.Q));
        System.out.println(q.front+" "+q.rear);
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        System.out.println(Arrays.toString(q.Q));
        System.out.println(q.front+" "+q.rear);
        q.enqueue(0);
        q.enqueue(2);
        q.enqueue(5);
        q.enqueue(10);
        System.out.println(Arrays.toString(q.Q));
        System.out.println(q.front+" "+q.rear);
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        System.out.println(Arrays.toString(q.Q));
        System.out.println(q.front+" "+q.rear);
        q.enqueue(0);
        q.enqueue(2);
        q.enqueue(5);
        q.enqueue(10);
        System.out.println(Arrays.toString(q.Q));
        System.out.println(q.front+" "+q.rear);
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        System.out.println(Arrays.toString(q.Q));
        System.out.println(q.front+" "+q.rear);
    }
}
