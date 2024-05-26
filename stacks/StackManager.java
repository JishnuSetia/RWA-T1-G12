package stacks;
public class StackManager{
    private int[] stack;
    private int top=0;
    public StackManager(){
        stack = new int[10];
    }
    public StackManager(int len){
        stack = new int[len];
    }
    public int push(int n){
        if(top+1==stack.length){
            return -1;
        }else{
            stack[top++] = n;
            return n;
        }
    }
    public int pop(){
        if(top-1<0){
            return -1;
        }else{
            return stack[--top];
        }
    }
    public int peek(){
        return  stack[top];
    }
    public int length(){
        return top+1;
    }
}