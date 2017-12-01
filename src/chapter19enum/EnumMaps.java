package chapter19enum;

import java.util.EnumMap;
import java.util.Map;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/1
 * Mail:zhengjun1987@outlook.com
 */
public class EnumMaps {
    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> commandEnumMap = new EnumMap<>(AlarmPoints.class);
        commandEnumMap.put(AlarmPoints.KITCHEN, new Command() {
            @Override
            public void action() {
                System.out.println("Kitchen On Fire");
            }
        });
        commandEnumMap.put(AlarmPoints.BATHROOM, new Command() {
            @Override
            public void action() {
                System.out.println("Bathroom Alert!");
            }
        });
        for (Map.Entry<AlarmPoints, Command> alarmPointsCommandEntry : commandEnumMap.entrySet()) {
            System.out.print(alarmPointsCommandEntry.getKey()+":");
            alarmPointsCommandEntry.getValue().action();
//        BATHROOM:Bathroom Alert!
//        KITCHEN:Kitchen On Fire
        }
        commandEnumMap.get(AlarmPoints.BATHROOM).action();
//        Bathroom Alert!
    }
}
