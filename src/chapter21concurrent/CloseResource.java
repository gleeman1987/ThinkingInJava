package chapter21concurrent;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/18
 * Mail:zhengjun1987@outlook.com
 */
public class CloseResource {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(8080);
        InputStream localhost = new Socket("localhost", 8080).getInputStream();
        executorService.execute(new IOBlocked(localhost));
        executorService.execute(new IOBlocked(System.in));

        Thread.sleep(100);
        System.out.println(MyUtils.getCurrentTime() +"Shut down all threads!");
        executorService.shutdownNow();

        Thread.sleep(1000);
        System.out.println(MyUtils.getCurrentTime() +"Closing "+localhost.getClass().getSimpleName());
        localhost.close();

        Thread.sleep(1000);
        System.out.println(MyUtils.getCurrentTime() +"Closing "+System.in.getClass().getSimpleName());
        System.in.close();
    }
//2017-12-18 17:31:13:302  Waiting for read():
//2017-12-18 17:31:13:303  Waiting for read():
//2017-12-18 17:31:13:378  Shut down all threads!
//2017-12-18 17:31:14:378  Closing SocketInputStream
//2017-12-18 17:31:14:380  Interrupted from Blocked I/O
//2017-12-18 17:31:14:380  Exiting from IOBlocked.run  SocketInputStream
//2017-12-18 17:31:15:379  Closing BufferedInputStream
//
//2017-12-18 17:31:20:892  Interrupted from Blocked I/O
//2017-12-18 17:31:20:893  Exiting from IOBlocked.run  BufferedInputStream
}
