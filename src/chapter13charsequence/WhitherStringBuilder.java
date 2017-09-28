package chapter13charsequence;

public class WhitherStringBuilder {
    public String implicit(String[] fields){
        String result = "";
        for (int i = 0; i < fields.length; i++) {
            result += fields[i];
        }
        return result;
    }
    public String explicit(String[] fields){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < fields.length; i++) {
            stringBuffer.append(fields[i]);
        }
        return stringBuffer.toString();
    }
}
