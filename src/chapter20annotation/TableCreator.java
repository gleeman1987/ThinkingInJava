package chapter20annotation;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Arthur:zhengjun
 * E-mail:zhengjun1987@outlook.com
 * Date:2017/12/3
 * Project:ThinkingInJava
 */
public class TableCreator {
    public static void main(String[] args) {
        DBTable dbTable = Member.class.getAnnotation(DBTable.class);
        String tableName = dbTable.name().toUpperCase();
        if (tableName == null || tableName.length()<1) {
            tableName = DBTable.class.getSimpleName().toUpperCase();
        }
        ArrayList<String> columnDefs = new ArrayList<>();
        for (Field field : Member.class.getDeclaredFields()) {
            String columnName = null;
            Annotation[] annotations = field.getDeclaredAnnotations();
            if (annotations.length < 1){
                continue;
            }
            System.out.println("annotations[0] = " + annotations[0].getClass().getCanonicalName());
            if (annotations[0] instanceof SQLString){
                SQLString sqlString = (SQLString) annotations[0];
                columnName = sqlString.name().length()< 1?field.getName():sqlString.name();
                columnDefs.add(columnName + " VARCHAR("+sqlString.value()+")"+getConstraintsString(sqlString.constraints()));
            }
            if (annotations[0] instanceof SQLInteger){
                SQLInteger sqlInteger = (SQLInteger) annotations[0];
                columnName = sqlInteger.name().length()<1?field.getName():sqlInteger.name();
                columnDefs.add(columnName + " INT"+getConstraintsString(sqlInteger.constraints()));
            }
        }

        StringBuffer stringBuffer = new StringBuffer("CREATE TABLE " + tableName + " (");
        for (String columnDef : columnDefs) {
            stringBuffer.append("\n "+columnDef+",");
        }
        String s = stringBuffer.toString().substring(0, stringBuffer.length() - 1) + ")";
        System.out.println("Table Creation SQL for "+Member.class.getSimpleName()+" :\n " + s);
    }
//    annotations[0] = com.sun.proxy.$Proxy3
//    annotations[0] = com.sun.proxy.$Proxy3
//    annotations[0] = com.sun.proxy.$Proxy4
//    annotations[0] = com.sun.proxy.$Proxy3
//    Table Creation SQL for Member :
//    CREATE TABLE MEMBERS (
//    firstName VARCHAR(30) NOT NULL,
//    lastName VARCHAR(50) NOT NULL,
//    age INT NOT NULL,
//    handle VARCHAR(30) NOT NULL PRIMARY KEY)

    private static String getConstraintsString(Constraints constraints) {
        String result = "";
        if (!constraints.allowNull()) {
            result += " NOT NULL";
        }
        if (constraints.primaryKey()) {
            result += " PRIMARY KEY";
        }
        if (constraints.unique()) {
            result += " UNIQUE";
        }
        return result;
    }
}
