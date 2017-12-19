package chapter21concurrent;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Author:Zheng Jun
 * E-mail:zhengjun1987@outlook.com
 * Date:2017/12/18
 * Project:ThinkingInJava
 */
public class NIOBlocked implements Runnable {
    private final SocketChannel socketChannel;

    public NIOBlocked(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        try {
            System.out.println(MyUtils.getCurrentTime() +"Waiting for read() in "+this);
            int read = socketChannel.read(ByteBuffer.allocate(1));
        } catch (ClosedByInterruptException e) {
            System.out.println(MyUtils.getCurrentTime() +"ClosedByInterruptException");
        } catch (AsynchronousCloseException e) {
            System.out.println(MyUtils.getCurrentTime() +"AsynchronousCloseException");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(MyUtils.getCurrentTime() + "Exiting NIOBlocked.run  " + this);
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(8080);
        InetSocketAddress localhost = new InetSocketAddress("localhost", 8080);
        SocketChannel socketChannel1 = SocketChannel.open(localhost);
        SocketChannel socketChannel2 = SocketChannel.open(localhost);
        Future<?> future = executorService.submit(new NIOBlocked(socketChannel1));
        executorService.execute(new NIOBlocked(socketChannel2));
        executorService.shutdown();
        System.out.println(MyUtils.getCurrentTime() +"Two tasks in queue!");
        Thread.sleep(1000);
        System.out.println(MyUtils.getCurrentTime() +"=====================");
        System.out.println(MyUtils.getCurrentTime() +"Canceling sC1 !!!");
        future.cancel(true);

        Thread.sleep(1000);
        System.out.println(MyUtils.getCurrentTime() +"=====================");
        System.out.println(MyUtils.getCurrentTime() +"Closing sC2 !!!");
        socketChannel2.close();
//        2017-12-19 17:01:55:427  Waiting for read() in chapter21concurrent.NIOBlocked@2cf5c8f6
//        2017-12-19 17:01:55:428  Two tasks in queue!
//        2017-12-19 17:01:55:429  Waiting for read() in chapter21concurrent.NIOBlocked@24189895
//        2017-12-19 17:01:56:430  =====================
//        2017-12-19 17:01:56:431  Canceling sC1 !!!
//        2017-12-19 17:01:56:434  ClosedByInterruptException
//        2017-12-19 17:01:56:434  Exiting NIOBlocked.run  chapter21concurrent.NIOBlocked@24189895
//        2017-12-19 17:01:57:435  =====================
//        2017-12-19 17:01:57:435  Closing sC2 !!!
//        2017-12-19 17:01:57:436  AsynchronousCloseException
//        2017-12-19 17:01:57:436  Exiting NIOBlocked.run  chapter21concurrent.NIOBlocked@2cf5c8f6
//
//        Process finished with exit code 0
    }
}
