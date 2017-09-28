package chapter12exeception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/9/16.
 */
public class LoggingExeception extends Exception {
    private static final String TAG = "LoggingExeception";
    private static Logger logger = Logger.getLogger(TAG);

    public LoggingExeception() {
        System.out.println(logger.getName());
        StringWriter stringWriter = new StringWriter();
        printStackTrace(new PrintWriter(stringWriter));
        logger.severe(stringWriter.toString());
    }
}

class LoggingExeceptions {
    public static void main(String[] args) {
        try {
            throw new LoggingExeception();
        } catch (LoggingExeception loggingExeception) {
            System.err.println("Caught "+ loggingExeception);
        }
        try {
            throw new LoggingExeception();
        } catch (LoggingExeception loggingExeception) {
            System.err.println("Caught "+ loggingExeception);
        }
    }
}