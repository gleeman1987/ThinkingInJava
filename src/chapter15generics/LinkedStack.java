package chapter15generics;

public class LinkedStack<T> {
    private static class Node<U> {
        U item;
        Node<U> next;
        public Node() {
        }

        public Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        boolean end(){
            return item == null && next == null;
        }
    }

    //栈顶第一个元素
    private Node<T> top = new Node<>();

    public void push(T item){
        top = new Node<>(item,top);
    }

    public T pop(){
        T item = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return item;
    }

    public static void main(String[] args) {
        LinkedStack<String> stringLinkedStack = new LinkedStack<>();
        for (String s : "Phasers on stun".split(" ")) {
            stringLinkedStack.push(s);
        }

        String s;
        while ((s = stringLinkedStack.pop()) != null){
            System.out.println("s = " + s);
        }
//        s = stun
//        s = on
//        s = Phasers
    }
}
