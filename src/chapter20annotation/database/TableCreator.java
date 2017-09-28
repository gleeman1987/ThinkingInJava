package chapter20annotation.database;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/6/19.
 */
public class TableCreator {

    private static String tableName;

    public static void main(String[] args) throws ClassNotFoundException {
        args = new String[]{"database.Member"};
        int length = args.length;
        if (length < 1){
            System.out.println("arguments:annoted classes");
            System.exit(0);
        }
        for (String arg : args) {
            Class<?> aClass = Class.forName(arg);
            DBTable annotation = aClass.getAnnotation(DBTable.class);
            if (annotation == null) {
                System.out.println("No DBTable annotation found in class "+arg);
                continue;
            }
            tableName = annotation.name();
            if (tableName == null) {
                tableName = aClass.getSimpleName().toUpperCase();
            }

            ArrayList<String> columnConstraints = new ArrayList<>();
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                String columnName = null;
                columnName = declaredField.getName();
                Annotation[] annotations = declaredField.getAnnotations();
                if (annotations == null || annotations.length < 1) {
                    continue;
                }
                if (annotations[0] instanceof SQLInteger){
                    SQLInteger sqlInteger = (SQLInteger) annotations[0];
                    String name = sqlInteger.name();
                    if (name != null && name.length() > 0) {
                        columnName = name;
                    }
                    columnConstraints.add(columnName + " INT"+ getConstraints(sqlInteger.constraints()));
                }
                if (annotations[0] instanceof SQLString){
                    SQLString sqlString = (SQLString) annotations[0];
                    String name = sqlString.name();
                    if (name != null && name.length() > 0) {
                        columnName = name;
                    }
                    columnConstraints.add(columnName + " VARCHAR("+sqlString.value()+")"+getConstraints(sqlString.constraint()));
                }
            }
            StringBuffer stringBuffer = new StringBuffer("CREATE TABLE " + tableName + " (");
            for (String columnConstraint : columnConstraints) {
                stringBuffer.append("\n  "+columnConstraint+" ,");
            }
            String s = stringBuffer.substring(0, stringBuffer.length() - 1) + " );";
            System.out.println("最终SQL语句:  "+s);
        }
    }

    private static String getConstraints(Constraints constraints) {
        String ret = "";
        if (!constraints.allowNull()) {
            ret += " NOT NULL";
        }
        if (constraints.primaryKey()) {
            ret += " PRIMARY KEY";
        }
        if (constraints.unique()) {
            ret += " UNIQUE";
        }
        return ret;
    }
}
