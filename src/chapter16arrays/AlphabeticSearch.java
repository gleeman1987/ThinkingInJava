package chapter16arrays;

import java.util.Arrays;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/25
 * Mail:zhengjun1987@outlook.com
 */
public class AlphabeticSearch {
    public static void main(String[] args) {
        String[] strings = Generated.array(new String[30], new RandomGenerator.String(5));
        Arrays.sort(strings,String.CASE_INSENSITIVE_ORDER);
        System.out.println("Arrays.toString(strings) = " + Arrays.toString(strings));
        int location = Arrays.binarySearch(strings, strings[10], String.CASE_INSENSITIVE_ORDER);
        System.out.println(strings[10]+"  index:"+location);
//        Arrays.toString(strings) = [aaIkB, EurnT, FgIQT, GnfNg, gRidU, GVAZx, iLZIN, KdIYS, KmGCQ, KxFjJ, LkRaf, LlLgz, lWcbx, MqmgB, NhNqm, ojDNx, PpcHB, rJVFu, rTKsi, sGodp, UCgqY, ueBtc, upjFh, wBctI, wSLgJ, wwqhP, xgOht, XWmkW, YTtxk, ZHZrs]
//        LkRaf  index:10
    }
}
