package chapter19enum;

import com.sun.istack.internal.NotNull;

import java.text.DateFormat;
import java.util.Date;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/1
 * Mail:zhengjun1987@outlook.com
 */
public enum ConstantSpecificMethod {
    DATE_TIME {
        @Override
        String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    },

    CLASS_PATH {
        @Override
        @NotNull String getInfo() {
//            return System.getenv("CLASSPATH");
            return null;
        }
    },

    VERSION {
        @Override
        String getInfo() {
            return System.getProperty("java.version");
        }
    },
    ;
    abstract String getInfo();

    public static void main(@NotNull String[] args) {
        for (ConstantSpecificMethod constantSpecificMethod : values()) {
            System.out.println(constantSpecificMethod.name() + " = " + constantSpecificMethod.getInfo());
        }
//        DATE_TIME = 2017-12-1
//        CLASS_PATH = C:\Program Files\Java\jdk1.8.0_144\\lib\tools.jar ;C:\Program Files\Java\jdk1.8.0_144\\bin;C:\Users\Lenovo\gradle\gradle-3.4.1\\bin
//        VERSION = 1.8.0_144
    }
}
