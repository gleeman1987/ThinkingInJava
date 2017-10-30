package chapter17containeradvanced;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/30
 * Mail:zhengjun1987@outlook.com
 */
public class DequeTest {
    static void fillTest(Dequeue<Integer> deque){
        for (int i = 20; i < 27; i++) {
            deque.addFirst(i);
        }
        for (int i = 50; i < 55; i++) {
            deque.addLast(i);
        }
    }
    public static void main(String[] args) {
        Dequeue<Integer> integerDeque = new Dequeue<>();
        fillTest(integerDeque);
        while (integerDeque.size() !=0)
            System.out.print(integerDeque.removeFirst()+" ");
        System.out.println();
        fillTest(integerDeque);
        while (integerDeque.size() != 0) {
            System.out.print(integerDeque.removeLast()+" ");
        }
//        26 25 24 23 22 21 20 50 51 52 53 54
//        54 53 52 51 50 20 21 22 23 24 25 26
    }
}
