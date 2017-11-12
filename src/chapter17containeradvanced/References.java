package chapter17containeradvanced;

import java.lang.ref.*;
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
//        Just created:java.lang.ref.SoftReference@610455d6
//        Just created:java.lang.ref.SoftReference@511d50c0
//        Just created:java.lang.ref.SoftReference@60e53b93
//        Just created:java.lang.ref.SoftReference@5e2de80c
//        Just created:java.lang.ref.SoftReference@1d44bcfa
//        Just created:java.lang.ref.SoftReference@266474c2
//        Just created:java.lang.ref.SoftReference@6f94fa3e
//        Just created:java.lang.ref.SoftReference@5e481248
//        Just created:java.lang.ref.SoftReference@66d3c617
//        Just created:java.lang.ref.SoftReference@63947c6b

        LinkedList<WeakReference<VeryBig>> weakReferences = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            weakReferences.add(new WeakReference<VeryBig>(new VeryBig("Weak "+i),referenceQueue));
            System.out.println("Just created:"+weakReferences.getLast());
            checkQueue();
        }
//        Just created:java.lang.ref.WeakReference@2b193f2d
//        Just created:java.lang.ref.WeakReference@355da254
//        Just created:java.lang.ref.WeakReference@4dc63996
//        Just created:java.lang.ref.WeakReference@d716361
//        Just created:java.lang.ref.WeakReference@6ff3c5b5
//        Just created:java.lang.ref.WeakReference@3764951d
//        Just created:java.lang.ref.WeakReference@4b1210ee
//        Just created:java.lang.ref.WeakReference@4d7e1886
//        Just created:java.lang.ref.WeakReference@3cd1a2f1
//        Just created:java.lang.ref.WeakReference@2f0e140b

        SoftReference<VeryBig> soft = new SoftReference<>(new VeryBig("Soft"));
        WeakReference<VeryBig> weak = new WeakReference<>(new VeryBig("Weak"));
        System.gc();
//        Finalizing VeryBig{ident='Weak 6'}
//        Finalizing VeryBig{ident='Weak'}
//        Finalizing VeryBig{ident='Weak 9'}
//        Finalizing VeryBig{ident='Weak 8'}
//        Finalizing VeryBig{ident='Weak 7'}
//        Finalizing VeryBig{ident='Weak 5'}
//        Finalizing VeryBig{ident='Weak 4'}
//        Finalizing VeryBig{ident='Weak 3'}
//        Finalizing VeryBig{ident='Weak 2'}
//        Finalizing VeryBig{ident='Weak 1'}
//        Finalizing VeryBig{ident='Weak 0'}

        LinkedList<PhantomReference<VeryBig>> phantomReferences = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            phantomReferences.add(new PhantomReference<>(new VeryBig("Phantom "+i),referenceQueue));
            System.out.println("Just created:"+phantomReferences.getLast());
            checkQueue();
        }//Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/bin/java -Didea.launcher.port=7532 "-Didea.launcher.bin.path=/Applications/IntelliJ IDEA 15.app/Contents/bin" -Dfile.encoding=UTF-8 -classpath "/Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/jre/lib/charsets.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/jre/lib/deploy.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/jre/lib/ext/cldrdata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/jre/lib/ext/dnsns.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/jre/lib/ext/jfxrt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/jre/lib/ext/localedata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/jre/lib/ext/nashorn.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/jre/lib/ext/sunec.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/jre/lib/ext/sunjce_provider.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/jre/lib/ext/sunpkcs11.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/jre/lib/ext/zipfs.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/jre/lib/javaws.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/jre/lib/jce.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/jre/lib/jfr.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/jre/lib/jfxswt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/jre/lib/jsse.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/jre/lib/management-agent.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/jre/lib/plugin.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/jre/lib/resources.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/jre/lib/rt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/lib/ant-javafx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/lib/dt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/lib/javafx-mx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/lib/jconsole.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/lib/packager.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/lib/sa-jdi.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/lib/tools.jar:/Users/zhengjun/IdeaProjects/ThinkingInJava/out/production/ThinkingInJava:/Applications/IntelliJ IDEA 15.app/Contents/lib/idea_rt.jar" com.intellij.rt.execution.application.AppMain chapter17containeradvanced.References
//        Just created:java.lang.ref.PhantomReference@7440e464
//        poll.get() = null
//        Just created:java.lang.ref.PhantomReference@49476842
//        poll.get() = null
//        Just created:java.lang.ref.PhantomReference@78308db1
//        poll.get() = null
//        Just created:java.lang.ref.PhantomReference@27c170f0
//        poll.get() = null
//        Just created:java.lang.ref.PhantomReference@5451c3a8
//        poll.get() = null
//        Just created:java.lang.ref.PhantomReference@2626b418
//        poll.get() = null
//        Just created:java.lang.ref.PhantomReference@5a07e868
//        poll.get() = null
//        Just created:java.lang.ref.PhantomReference@76ed5528
//        poll.get() = null
//        Just created:java.lang.ref.PhantomReference@2c7b84de
//        poll.get() = null
//        Just created:java.lang.ref.PhantomReference@3fee733d
//        poll.get() = null
    }
}
