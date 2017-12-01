package chapter19enum;

import java.util.EnumSet;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/30
 * Mail:zhengjun1987@outlook.com
 */
public class EnumSets {
    public static void main(String[] args) {
        EnumSet<AlarmPoints> alarmPoints = EnumSet.noneOf(AlarmPoints.class);
        System.out.println("alarmPoints = " + alarmPoints);
//        alarmPoints = []
        alarmPoints.add(AlarmPoints.BATHROOM);
        System.out.println("alarmPoints = " + alarmPoints);
//        alarmPoints = [BATHROOM]
        alarmPoints.addAll(EnumSet.of(AlarmPoints.STAIR1,AlarmPoints.STAIR2,AlarmPoints.STAIR3,AlarmPoints.KITCHEN));
        System.out.println("alarmPoints = " + alarmPoints);
//        alarmPoints = [STAIR1, STAIR2, STAIR3, BATHROOM, KITCHEN]

        alarmPoints = EnumSet.allOf(AlarmPoints.class);
        System.out.println("alarmPoints = " + alarmPoints);
//        alarmPoints = [STAIR1, STAIR2, STAIR3, LOBBY, OFFICE1, OFFICE2, OFFICE3, OFFICE4, BATHROOM, KITCHEN, UTILITY]
        alarmPoints.removeAll(EnumSet.of(AlarmPoints.STAIR1,AlarmPoints.STAIR2,AlarmPoints.STAIR3,AlarmPoints.KITCHEN));
        System.out.println("alarmPoints = " + alarmPoints);
//        alarmPoints = [LOBBY, OFFICE1, OFFICE2, OFFICE3, OFFICE4, BATHROOM, UTILITY]
        alarmPoints.removeAll(EnumSet.range(AlarmPoints.OFFICE1,AlarmPoints.OFFICE4));
        System.out.println("alarmPoints = " + alarmPoints);
//        alarmPoints = [LOBBY, BATHROOM, UTILITY]

        alarmPoints = EnumSet.complementOf(alarmPoints);
        System.out.println("alarmPoints = " + alarmPoints);
//        alarmPoints = [STAIR1, STAIR2, STAIR3, OFFICE1, OFFICE2, OFFICE3, OFFICE4, KITCHEN]
    }
}
