package chapter12exeception;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/9/16.
 */
public class ExeceptionWithCustomVariables {
    public static void main(String[] args) {
        try {
            f();
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                System.err.println(stackTraceElement.getMethodName()    );
            }
        }
    }

    static void f() throws CustomException {
        try {
            g();
        } catch (CustomException e) {
            throw (CustomException) e.fillInStackTrace();//调用该方法会使之前的stacktrace从此断掉,重新记录
        }
    }

    static void g() throws CustomException {
        throw new CustomException("必填参数为空",3099);
    }
}

class CustomException extends Exception{
    private int errCode;

    public CustomException(String message, int errCode) {
        super(message);
        this.errCode = errCode;
    }

    private int getErrCode() {
        return errCode;
    }

    @Override
    public String getMessage() {
        return "ErrCode:"+getErrCode()+" Message:"+super.getMessage();
    }
}
