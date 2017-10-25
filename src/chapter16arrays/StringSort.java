package chapter16arrays;

import java.util.Arrays;
import java.util.Collections;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/25
 * Mail:zhengjun1987@outlook.com
 */
public class StringSort {
    public static void main(String[] args) {
        String[] array = Generated.array(new String[20], new RandomGenerator.String(5));
        System.out.println("排序之前 = " + Arrays.toString(array));
//        排序之前 = [gRidU, MqmgB, FgIQT, LkRaf, KxFjJ, XWmkW, YTtxk, rTKsi, iLZIN, ZHZrs, EurnT, NhNqm, ueBtc, GVAZx, lWcbx, upjFh, KdIYS, KmGCQ, UCgqY, xgOht]
        Arrays.sort(array);
        System.out.println("排序之后 = " + Arrays.toString(array));
//        排序之后 = [EurnT, FgIQT, GVAZx, KdIYS, KmGCQ, KxFjJ, LkRaf, MqmgB, NhNqm, UCgqY, XWmkW, YTtxk, ZHZrs, gRidU, iLZIN, lWcbx, rTKsi, ueBtc, upjFh, xgOht]
        Arrays.sort(array, Collections.reverseOrder());
        System.out.println("倒序排序之后 = " + Arrays.toString(array));
//        倒序排序之后 = [xgOht, upjFh, ueBtc, rTKsi, lWcbx, iLZIN, gRidU, ZHZrs, YTtxk, XWmkW, UCgqY, NhNqm, MqmgB, LkRaf, KxFjJ, KmGCQ, KdIYS, GVAZx, FgIQT, EurnT]
        Arrays.sort(array,String.CASE_INSENSITIVE_ORDER);
        System.out.println("无大小写排序之后 = " + Arrays.toString(array));
//        无大小写排序之后 = [EurnT, FgIQT, gRidU, GVAZx, iLZIN, KdIYS, KmGCQ, KxFjJ, LkRaf, lWcbx, MqmgB, NhNqm, rTKsi, UCgqY, ueBtc, upjFh, xgOht, XWmkW, YTtxk, ZHZrs]

    }
}
