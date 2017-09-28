package chapter20annotation;

import java.util.List;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/6/19.
 */
public class PasswordUtils {
    @UseCase(id = 45,description = "password must contain at least 1 digital character")
    public boolean validatePassword(String password){
        return password.matches("\\w*\\d\\w*");
    }

    @UseCase(id = 46)
    public String encryptPassword(String password){
        return new StringBuffer(password).reverse().toString();
    }

    @UseCase(id = 47,description = "new password cannot equal the used ones")
    public boolean checkForNewPassword(List<String> previousPassword,String newPassword){
        return !previousPassword.contains(newPassword);
    }
}
