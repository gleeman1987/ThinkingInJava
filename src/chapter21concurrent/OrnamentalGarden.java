package chapter21concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/14
 * Mail:zhengjun1987@outlook.com
 */
class Count {
    private int count;
    private Random random = new Random(47);
    public synchronized int increment(){
        int temp = count;
        if (random.nextBoolean()) {
            Thread.yield();
        }
        return (count = ++temp);
    }
    public synchronized int value(){
        return count;
    }
}

class Entrance implements Runnable {
    private static Count count = new Count();
    private static List<Entrance> entrances = new ArrayList<>();
    private int number = 0;
    private final int id;

    public Entrance(int id) {
        this.id = id;
        entrances.add(this);
    }

    private static volatile boolean canceled = false;
    public static void cancel(){
        canceled = true;
    }

    @Override
    public void run() {
        while (!canceled) {
            synchronized (this){
                ++number;
            }
            System.out.println(MyUtils.getCurrentTime() +this+"  Total:"+count.increment());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(MyUtils.getCurrentTime() +"Stopping "+this);
    }

    public synchronized int getNumber(){
        return number;
    }

    @Override
    public String toString() {
        return "Entrance "+id+":"+getNumber();
    }

    public static int getTotalCount(){
        return count.value();
    }

    public static int sumEntrances(){
        int sum = 0;
        for (Entrance entrance : entrances) {
            sum += entrance.getNumber();
        }
        return sum;
    }
}

public class OrnamentalGarden {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Entrance(i));
        }
        Thread.sleep(3000);
        Entrance.cancel();
        executorService.shutdown();
        if (!executorService.awaitTermination(250,TimeUnit.MILLISECONDS)){
            System.out.println(MyUtils.getCurrentTime() +"某些线程没有终止");
        }
        System.out.println(MyUtils.getCurrentTime() +"Total:"+Entrance.getTotalCount());
        System.out.println(MyUtils.getCurrentTime() +"Sum of Entrances:"+Entrance.sumEntrances());
    }
//            2017-12-14 18:10:49:304  Entrance 0:1  Total:1
//            2017-12-14 18:10:49:304  Entrance 4:1  Total:2
//            2017-12-14 18:10:49:304  Entrance 3:1  Total:3
//            2017-12-14 18:10:49:304  Entrance 2:1  Total:4
//            2017-12-14 18:10:49:304  Entrance 1:1  Total:5
//            2017-12-14 18:10:49:410  Entrance 1:2  Total:6
//            2017-12-14 18:10:49:410  Entrance 0:2  Total:8
//            2017-12-14 18:10:49:410  Entrance 4:2  Total:7
//            2017-12-14 18:10:49:410  Entrance 3:2  Total:9
//            2017-12-14 18:10:49:410  Entrance 2:2  Total:10
//            2017-12-14 18:10:49:515  Entrance 0:3  Total:11
//            2017-12-14 18:10:49:515  Entrance 2:3  Total:12
//            2017-12-14 18:10:49:515  Entrance 3:3  Total:15
//            2017-12-14 18:10:49:515  Entrance 1:3  Total:14
//            2017-12-14 18:10:49:515  Entrance 4:3  Total:13
//            2017-12-14 18:10:49:615  Entrance 0:4  Total:16
//            2017-12-14 18:10:49:616  Entrance 4:4  Total:17
//            2017-12-14 18:10:49:616  Entrance 1:4  Total:18
//            2017-12-14 18:10:49:616  Entrance 3:4  Total:19
//            2017-12-14 18:10:49:616  Entrance 2:4  Total:20
//            2017-12-14 18:10:49:725  Entrance 0:5  Total:21
//            2017-12-14 18:10:49:725  Entrance 2:5  Total:22
//            2017-12-14 18:10:49:725  Entrance 1:5  Total:24
//            2017-12-14 18:10:49:725  Entrance 3:5  Total:25
//            2017-12-14 18:10:49:725  Entrance 4:5  Total:23
//            2017-12-14 18:10:49:834  Entrance 0:6  Total:26
//            2017-12-14 18:10:49:834  Entrance 4:6  Total:28
//            2017-12-14 18:10:49:834  Entrance 3:6  Total:29
//            2017-12-14 18:10:49:834  Entrance 2:6  Total:27
//            2017-12-14 18:10:49:834  Entrance 1:6  Total:30
//            2017-12-14 18:10:49:939  Entrance 0:7  Total:31
//            2017-12-14 18:10:49:939  Entrance 1:7  Total:32
//            2017-12-14 18:10:49:939  Entrance 2:7  Total:34
//            2017-12-14 18:10:49:939  Entrance 3:7  Total:33
//            2017-12-14 18:10:49:939  Entrance 4:7  Total:35
//            2017-12-14 18:10:50:047  Entrance 0:8  Total:36
//            2017-12-14 18:10:50:047  Entrance 3:8  Total:37
//            2017-12-14 18:10:50:047  Entrance 4:8  Total:38
//            2017-12-14 18:10:50:047  Entrance 1:8  Total:39
//            2017-12-14 18:10:50:047  Entrance 2:8  Total:40
//            2017-12-14 18:10:50:147  Entrance 1:9  Total:41
//            2017-12-14 18:10:50:147  Entrance 0:9  Total:42
//            2017-12-14 18:10:50:147  Entrance 3:9  Total:43
//            2017-12-14 18:10:50:147  Entrance 4:9  Total:44
//            2017-12-14 18:10:50:147  Entrance 2:9  Total:45
//            2017-12-14 18:10:50:247  Entrance 1:10  Total:46
//            2017-12-14 18:10:50:247  Entrance 2:10  Total:47
//            2017-12-14 18:10:50:247  Entrance 3:10  Total:48
//            2017-12-14 18:10:50:247  Entrance 4:10  Total:49
//            2017-12-14 18:10:50:247  Entrance 0:10  Total:50
//            2017-12-14 18:10:50:351  Entrance 1:11  Total:51
//            2017-12-14 18:10:50:351  Entrance 3:11  Total:53
//            2017-12-14 18:10:50:351  Entrance 0:11  Total:52
//            2017-12-14 18:10:50:351  Entrance 4:11  Total:55
//            2017-12-14 18:10:50:351  Entrance 2:11  Total:54
//            2017-12-14 18:10:50:452  Entrance 1:12  Total:56
//            2017-12-14 18:10:50:452  Entrance 2:12  Total:57
//            2017-12-14 18:10:50:453  Entrance 4:12  Total:58
//            2017-12-14 18:10:50:453  Entrance 0:12  Total:59
//            2017-12-14 18:10:50:453  Entrance 3:12  Total:60
//            2017-12-14 18:10:50:554  Entrance 1:13  Total:62
//            2017-12-14 18:10:50:554  Entrance 3:13  Total:61
//            2017-12-14 18:10:50:554  Entrance 0:13  Total:63
//            2017-12-14 18:10:50:554  Entrance 2:13  Total:65
//            2017-12-14 18:10:50:554  Entrance 4:13  Total:64
//            2017-12-14 18:10:50:679  Entrance 4:14  Total:66
//            2017-12-14 18:10:50:679  Entrance 3:14  Total:67
//            2017-12-14 18:10:50:679  Entrance 0:14  Total:69
//            2017-12-14 18:10:50:679  Entrance 2:14  Total:70
//            2017-12-14 18:10:50:679  Entrance 1:14  Total:68
//            2017-12-14 18:10:50:789  Entrance 2:15  Total:71
//            2017-12-14 18:10:50:789  Entrance 4:15  Total:72
//            2017-12-14 18:10:50:789  Entrance 3:15  Total:73
//            2017-12-14 18:10:50:789  Entrance 0:15  Total:74
//            2017-12-14 18:10:50:789  Entrance 1:15  Total:75
//            2017-12-14 18:10:50:889  Entrance 1:16  Total:76
//            2017-12-14 18:10:50:889  Entrance 2:16  Total:77
//            2017-12-14 18:10:50:889  Entrance 4:16  Total:78
//            2017-12-14 18:10:50:889  Entrance 3:16  Total:79
//            2017-12-14 18:10:50:889  Entrance 0:16  Total:80
//            2017-12-14 18:10:50:989  Entrance 0:17  Total:81
//            2017-12-14 18:10:50:989  Entrance 1:17  Total:82
//            2017-12-14 18:10:50:990  Entrance 2:17  Total:83
//            2017-12-14 18:10:50:990  Entrance 4:17  Total:84
//            2017-12-14 18:10:50:990  Entrance 3:17  Total:85
//            2017-12-14 18:10:51:094  Entrance 2:18  Total:86
//            2017-12-14 18:10:51:094  Entrance 0:18  Total:87
//            2017-12-14 18:10:51:094  Entrance 4:18  Total:88
//            2017-12-14 18:10:51:094  Entrance 3:18  Total:89
//            2017-12-14 18:10:51:094  Entrance 1:18  Total:90
//            2017-12-14 18:10:51:195  Entrance 3:19  Total:91
//            2017-12-14 18:10:51:195  Entrance 2:19  Total:92
//            2017-12-14 18:10:51:195  Entrance 0:19  Total:93
//            2017-12-14 18:10:51:195  Entrance 4:19  Total:94
//            2017-12-14 18:10:51:195  Entrance 1:19  Total:95
//            2017-12-14 18:10:51:295  Entrance 0:20  Total:96
//            2017-12-14 18:10:51:296  Entrance 1:20  Total:97
//            2017-12-14 18:10:51:296  Entrance 4:20  Total:98
//            2017-12-14 18:10:51:296  Entrance 2:20  Total:99
//            2017-12-14 18:10:51:296  Entrance 3:20  Total:100
//            2017-12-14 18:10:51:396  Entrance 0:21  Total:101
//            2017-12-14 18:10:51:396  Entrance 2:21  Total:102
//            2017-12-14 18:10:51:396  Entrance 3:21  Total:103
//            2017-12-14 18:10:51:396  Entrance 4:21  Total:104
//            2017-12-14 18:10:51:397  Entrance 1:21  Total:105
//            2017-12-14 18:10:51:497  Entrance 2:22  Total:106
//            2017-12-14 18:10:51:497  Entrance 0:22  Total:107
//            2017-12-14 18:10:51:498  Entrance 1:22  Total:108
//            2017-12-14 18:10:51:498  Entrance 3:22  Total:109
//            2017-12-14 18:10:51:498  Entrance 4:22  Total:110
//            2017-12-14 18:10:51:598  Entrance 2:23  Total:111
//            2017-12-14 18:10:51:598  Entrance 0:23  Total:112
//            2017-12-14 18:10:51:599  Entrance 1:23  Total:113
//            2017-12-14 18:10:51:599  Entrance 3:23  Total:114
//            2017-12-14 18:10:51:600  Entrance 4:23  Total:115
//            2017-12-14 18:10:51:711  Entrance 3:24  Total:116
//            2017-12-14 18:10:51:711  Entrance 2:24  Total:117
//            2017-12-14 18:10:51:711  Entrance 1:24  Total:119
//            2017-12-14 18:10:51:711  Entrance 0:24  Total:118
//            2017-12-14 18:10:51:711  Entrance 4:24  Total:120
//            2017-12-14 18:10:51:820  Entrance 3:25  Total:121
//            2017-12-14 18:10:51:820  Entrance 4:25  Total:122
//            2017-12-14 18:10:51:820  Entrance 0:25  Total:123
//            2017-12-14 18:10:51:820  Entrance 1:25  Total:124
//            2017-12-14 18:10:51:820  Entrance 2:25  Total:125
//            2017-12-14 18:10:51:923  Entrance 4:26  Total:126
//            2017-12-14 18:10:51:923  Entrance 1:26  Total:127
//            2017-12-14 18:10:51:923  Entrance 2:26  Total:128
//            2017-12-14 18:10:51:923  Entrance 0:26  Total:129
//            2017-12-14 18:10:51:923  Entrance 3:26  Total:130
//            2017-12-14 18:10:52:032  Entrance 4:27  Total:131
//            2017-12-14 18:10:52:032  Entrance 3:27  Total:132
//            2017-12-14 18:10:52:032  Entrance 0:27  Total:133
//            2017-12-14 18:10:52:032  Entrance 2:27  Total:134
//            2017-12-14 18:10:52:032  Entrance 1:27  Total:135
//            2017-12-14 18:10:52:141  Entrance 4:28  Total:136
//            2017-12-14 18:10:52:141  Entrance 1:28  Total:137
//            2017-12-14 18:10:52:141  Entrance 3:28  Total:138
//            2017-12-14 18:10:52:141  Entrance 2:28  Total:139
//            2017-12-14 18:10:52:142  Entrance 0:28  Total:140
//            2017-12-14 18:10:52:242  Entrance 3:29  Total:141
//            2017-12-14 18:10:52:242  Entrance 4:29  Total:142
//            2017-12-14 18:10:52:242  Entrance 1:29  Total:143
//            2017-12-14 18:10:52:243  Entrance 2:29  Total:144
//            2017-12-14 18:10:52:243  Entrance 0:29  Total:145
//            2017-12-14 18:10:52:283  Total:145
//            2017-12-14 18:10:52:283  Sum of Entrances:145
//            2017-12-14 18:10:52:342  Stopping Entrance 3:29
//            2017-12-14 18:10:52:342  Stopping Entrance 4:29
//            2017-12-14 18:10:52:343  Stopping Entrance 1:29
//            2017-12-14 18:10:52:343  Stopping Entrance 2:29
//            2017-12-14 18:10:52:343  Stopping Entrance 0:29
}
