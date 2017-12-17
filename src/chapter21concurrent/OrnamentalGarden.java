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

    //volatile关键字--只能进行读取和赋值（无需运算等复杂非原子化操作）
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

//        等待线程池executorService中的所有任务结束，如果在规定的时间内所有任务均已结束则返回true，否则返回false
        if (!executorService.awaitTermination(250,TimeUnit.MILLISECONDS)){
            System.out.println(MyUtils.getCurrentTime() +"某些线程没有终止");
        }
        System.out.println(MyUtils.getCurrentTime() +"Total:"+Entrance.getTotalCount());//此时Entrance实例中的信息仍可用
        System.out.println(MyUtils.getCurrentTime() +"Sum of Entrances:"+Entrance.sumEntrances());
    }
//            2017-12-15 01:20:07:347  Entrance 0:1  Total:1
//            2017-12-15 01:20:07:348  Entrance 4:1  Total:2
//            2017-12-15 01:20:07:349  Entrance 3:1  Total:3
//            2017-12-15 01:20:07:349  Entrance 2:1  Total:5
//            2017-12-15 01:20:07:349  Entrance 1:1  Total:4
//            2017-12-15 01:20:07:454  Entrance 3:2  Total:6
//            2017-12-15 01:20:07:454  Entrance 0:2  Total:7
//            2017-12-15 01:20:07:454  Entrance 1:2  Total:8
//            2017-12-15 01:20:07:455  Entrance 4:2  Total:9
//            2017-12-15 01:20:07:455  Entrance 2:2  Total:10
//            2017-12-15 01:20:07:556  Entrance 3:3  Total:11
//            2017-12-15 01:20:07:557  Entrance 2:3  Total:12
//            2017-12-15 01:20:07:557  Entrance 0:3  Total:15
//            2017-12-15 01:20:07:557  Entrance 4:3  Total:14
//            2017-12-15 01:20:07:558  Entrance 1:3  Total:13
//            2017-12-15 01:20:07:661  Entrance 3:4  Total:16
//            2017-12-15 01:20:07:662  Entrance 1:4  Total:17
//            2017-12-15 01:20:07:662  Entrance 0:4  Total:19
//            2017-12-15 01:20:07:662  Entrance 2:4  Total:18
//            2017-12-15 01:20:07:662  Entrance 4:4  Total:20
//            2017-12-15 01:20:07:763  Entrance 3:5  Total:21
//            2017-12-15 01:20:07:764  Entrance 1:5  Total:22
//            2017-12-15 01:20:07:764  Entrance 4:5  Total:23
//            2017-12-15 01:20:07:765  Entrance 2:5  Total:25
//            2017-12-15 01:20:07:765  Entrance 0:5  Total:24
//            2017-12-15 01:20:07:864  Entrance 3:6  Total:26
//            2017-12-15 01:20:07:865  Entrance 1:6  Total:27
//            2017-12-15 01:20:07:867  Entrance 4:6  Total:28
//            2017-12-15 01:20:07:867  Entrance 0:6  Total:29
//            2017-12-15 01:20:07:868  Entrance 2:6  Total:30
//            2017-12-15 01:20:07:967  Entrance 3:7  Total:31
//            2017-12-15 01:20:07:967  Entrance 1:7  Total:32
//            2017-12-15 01:20:07:968  Entrance 4:7  Total:33
//            2017-12-15 01:20:07:968  Entrance 0:7  Total:34
//            2017-12-15 01:20:07:970  Entrance 2:7  Total:35
//            2017-12-15 01:20:08:069  Entrance 3:8  Total:36
//            2017-12-15 01:20:08:076  Entrance 2:8  Total:37
//            2017-12-15 01:20:08:070  Entrance 4:8  Total:38
//            2017-12-15 01:20:08:070  Entrance 0:8  Total:39
//            2017-12-15 01:20:08:069  Entrance 1:8  Total:40
//            2017-12-15 01:20:08:178  Entrance 3:9  Total:41
//            2017-12-15 01:20:08:179  Entrance 2:9  Total:42
//            2017-12-15 01:20:08:180  Entrance 0:9  Total:43
//            2017-12-15 01:20:08:180  Entrance 4:9  Total:44
//            2017-12-15 01:20:08:190  Entrance 1:9  Total:45
//            2017-12-15 01:20:08:281  Entrance 3:10  Total:46
//            2017-12-15 01:20:08:282  Entrance 0:10  Total:47
//            2017-12-15 01:20:08:282  Entrance 2:10  Total:48
//            2017-12-15 01:20:08:292  Entrance 4:10  Total:49
//            2017-12-15 01:20:08:303  Entrance 1:10  Total:50
//            2017-12-15 01:20:08:383  Entrance 3:11  Total:51
//            2017-12-15 01:20:08:391  Entrance 0:11  Total:52
//            2017-12-15 01:20:08:391  Entrance 2:11  Total:53
//            2017-12-15 01:20:08:394  Entrance 4:11  Total:54
//            2017-12-15 01:20:08:405  Entrance 1:11  Total:55
//            2017-12-15 01:20:08:496  Entrance 0:12  Total:56
//            2017-12-15 01:20:08:497  Entrance 2:12  Total:57
//            2017-12-15 01:20:08:505  Entrance 3:12  Total:58
//            2017-12-15 01:20:08:506  Entrance 4:12  Total:59
//            2017-12-15 01:20:08:509  Entrance 1:12  Total:60
//            2017-12-15 01:20:08:602  Entrance 0:13  Total:61
//            2017-12-15 01:20:08:602  Entrance 2:13  Total:62
//            2017-12-15 01:20:08:606  Entrance 3:13  Total:63
//            2017-12-15 01:20:08:612  Entrance 1:13  Total:64
//            2017-12-15 01:20:08:608  Entrance 4:13  Total:65
//            2017-12-15 01:20:08:707  Entrance 0:14  Total:66
//            2017-12-15 01:20:08:708  Entrance 2:14  Total:67
//            2017-12-15 01:20:08:716  Entrance 3:14  Total:68
//            2017-12-15 01:20:08:717  Entrance 1:14  Total:69
//            2017-12-15 01:20:08:718  Entrance 4:14  Total:70
//            2017-12-15 01:20:08:815  Entrance 0:15  Total:71
//            2017-12-15 01:20:08:816  Entrance 2:15  Total:72
//            2017-12-15 01:20:08:822  Entrance 1:15  Total:73
//            2017-12-15 01:20:08:823  Entrance 3:15  Total:74
//            2017-12-15 01:20:08:823  Entrance 4:15  Total:75
//            2017-12-15 01:20:08:920  Entrance 0:16  Total:76
//            2017-12-15 01:20:08:921  Entrance 2:16  Total:77
//            2017-12-15 01:20:08:934  Entrance 1:16  Total:78
//            2017-12-15 01:20:08:948  Entrance 3:16  Total:79
//            2017-12-15 01:20:08:956  Entrance 4:16  Total:80
//            2017-12-15 01:20:09:025  Entrance 0:17  Total:81
//            2017-12-15 01:20:09:026  Entrance 2:17  Total:82
//            2017-12-15 01:20:09:036  Entrance 1:17  Total:83
//            2017-12-15 01:20:09:049  Entrance 3:17  Total:84
//            2017-12-15 01:20:09:062  Entrance 4:17  Total:85
//            2017-12-15 01:20:09:139  Entrance 0:18  Total:86
//            2017-12-15 01:20:09:140  Entrance 2:18  Total:87
//            2017-12-15 01:20:09:141  Entrance 1:18  Total:88
//            2017-12-15 01:20:09:159  Entrance 3:18  Total:89
//            2017-12-15 01:20:09:164  Entrance 4:18  Total:90
//            2017-12-15 01:20:09:244  Entrance 0:19  Total:91
//            2017-12-15 01:20:09:245  Entrance 1:19  Total:92
//            2017-12-15 01:20:09:245  Entrance 2:19  Total:93
//            2017-12-15 01:20:09:261  Entrance 3:19  Total:94
//            2017-12-15 01:20:09:266  Entrance 4:19  Total:95
//            2017-12-15 01:20:09:349  Entrance 1:20  Total:96
//            2017-12-15 01:20:09:349  Entrance 0:20  Total:97
//            2017-12-15 01:20:09:354  Entrance 2:20  Total:98
//            2017-12-15 01:20:09:365  Entrance 3:20  Total:99
//            2017-12-15 01:20:09:375  Entrance 4:20  Total:100
//            2017-12-15 01:20:09:450  Entrance 1:21  Total:101
//            2017-12-15 01:20:09:450  Entrance 0:21  Total:102
//            2017-12-15 01:20:09:457  Entrance 2:21  Total:103
//            2017-12-15 01:20:09:467  Entrance 3:21  Total:104
//            2017-12-15 01:20:09:480  Entrance 4:21  Total:105
//            2017-12-15 01:20:09:553  Entrance 1:22  Total:106
//            2017-12-15 01:20:09:554  Entrance 0:22  Total:107
//            2017-12-15 01:20:09:558  Entrance 2:22  Total:108
//            2017-12-15 01:20:09:569  Entrance 3:22  Total:109
//            2017-12-15 01:20:09:592  Entrance 4:22  Total:110
//            2017-12-15 01:20:09:657  Entrance 0:23  Total:111
//            2017-12-15 01:20:09:657  Entrance 1:23  Total:112
//            2017-12-15 01:20:09:663  Entrance 2:23  Total:113
//            2017-12-15 01:20:09:671  Entrance 3:23  Total:114
//            2017-12-15 01:20:09:694  Entrance 4:23  Total:115
//            2017-12-15 01:20:09:762  Entrance 1:24  Total:116
//            2017-12-15 01:20:09:762  Entrance 0:24  Total:117
//            2017-12-15 01:20:09:764  Entrance 2:24  Total:118
//            2017-12-15 01:20:09:776  Entrance 3:24  Total:119
//            2017-12-15 01:20:09:799  Entrance 4:24  Total:120
//            2017-12-15 01:20:09:865  Entrance 1:25  Total:121
//            2017-12-15 01:20:09:867  Entrance 0:25  Total:122
//            2017-12-15 01:20:09:869  Entrance 2:25  Total:123
//            2017-12-15 01:20:09:877  Entrance 3:25  Total:124
//            2017-12-15 01:20:09:903  Entrance 4:25  Total:125
//            2017-12-15 01:20:09:969  Entrance 1:26  Total:126
//            2017-12-15 01:20:09:973  Entrance 2:26  Total:127
//            2017-12-15 01:20:09:973  Entrance 0:26  Total:128
//            2017-12-15 01:20:09:981  Entrance 3:26  Total:129
//            2017-12-15 01:20:10:006  Entrance 4:26  Total:130
//            2017-12-15 01:20:10:073  Entrance 1:27  Total:131
//            2017-12-15 01:20:10:073  Entrance 2:27  Total:132
//            2017-12-15 01:20:10:075  Entrance 0:27  Total:133
//            2017-12-15 01:20:10:085  Entrance 3:27  Total:134
//            2017-12-15 01:20:10:113  Entrance 4:27  Total:135
//            2017-12-15 01:20:10:177  Entrance 0:28  Total:136
//            2017-12-15 01:20:10:178  Entrance 1:28  Total:137
//            2017-12-15 01:20:10:178  Entrance 2:28  Total:138
//            2017-12-15 01:20:10:188  Entrance 3:28  Total:139
//            2017-12-15 01:20:10:217  Entrance 4:28  Total:140
//            2017-12-15 01:20:10:281  Stopping Entrance 0:28
//            2017-12-15 01:20:10:282  Stopping Entrance 1:28
//            2017-12-15 01:20:10:282  Stopping Entrance 2:28
//            2017-12-15 01:20:10:294  Stopping Entrance 3:28
//            2017-12-15 01:20:10:320  Stopping Entrance 4:28
//            2017-12-15 01:20:10:321  Total:140
//            2017-12-15 01:20:10:322  Sum of Entrances:140
}
