package chapter17containeradvanced;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/9
 * Mail:zhengjun1987@outlook.com
 */
class VeryBig {
    public static final int SIZE = 10000;
    private long[] la = new long[SIZE];
    private String ident;

    public VeryBig(String ident) {
        this.ident = ident;
    }

    @Override
    public String toString() {
        return "VeryBig{" +
                "ident='" + ident + '\'' +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing "+toString());
    }
}

public class References {
    private static ReferenceQueue<VeryBig> referenceQueue = new ReferenceQueue<>();
    private static void checkQueue(){
        Reference<? extends VeryBig> poll = referenceQueue.poll();
        if (poll != null) {
            System.out.println("poll.get() = " + poll.get());
        }
    }

    public static void main(String[] args) {
        int size = 10;
        LinkedList<SoftReference<VeryBig>> softReferenceLinkedList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            softReferenceLinkedList.add(new SoftReference<VeryBig>(new VeryBig("Soft "+i),referenceQueue));
            System.out.println("Just created:"+softReferenceLinkedList.getLast());
            checkQueue();
        }

        LinkedList<WeakReference<VeryBig>> weakReferences = new LinkedList<>();

    }
}
