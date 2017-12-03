package chapter20annotation;

import java.util.List;

/**
 * Authur:zhengjun
 * E-mail:zhengjun1987@outlook.com
 * Date:2017/12/3
 * Project:ThinkingInJava
 */
public class PasswordUtils {

    @UseCase(id = 47, description = "password must contain at least one numeric")
    public boolean validatePassword(String password) {
        return password.matches("\\w*\\d\\w");
    }

    @UseCase(id = 49, description = "New password cannot equals previously used ones")
    public boolean checkNewPassword(List<String> previousPasswords,String password) {
        return previousPasswords == null || previousPasswords.isEmpty() || !previousPasswords.contains(password);
    }

    @UseCase(id = 48)
    public String encryptPassword(String password){
        return new StringBuilder(password).reverse().toString();
    }
}
