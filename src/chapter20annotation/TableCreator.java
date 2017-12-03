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
            if (annotations[0] instanceof SQLString){

            }
            if (annotations[0] instanceof SQLInteger){

            }
        }

    }
}
