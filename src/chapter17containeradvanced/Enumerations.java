package chapter17containeradvanced;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/12
 * Mail:zhengjun1987@outlook.com
 */
public class Enumerations {
    public static void main(String[] args) {
        Vector<String> strings = new Vector<>(Countries.names(10));
        Enumeration<String> elements = strings.elements();
        while (elements.hasMoreElements()){
            System.out.print(elements.nextElement()+" ");
        }
//        ALGERIA ANGOLA BENIN BOTSWANA BURKINA FASO BURUNDI CAMEROON CAPE VERDE CENTRAL AFRICAN REPUBLIC CHAD
        elements = Collections.enumeration(new ArrayList<>(Countries.names(10)));
    }
}
