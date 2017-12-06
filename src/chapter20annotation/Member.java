package chapter20annotation;

/**
 * Authur:zhengjun
 * E-mail:zhengjun1987@outlook.com
 * Date:2017/12/3
 * Project:ThinkingInJava
 */
@DBTable(name = "MEMBERS")
public class Member {
    @SQLString(30)
    String firstName;

    @SQLString(50)
    String lastName;

    @SQLInteger
    Integer age;

    @SQLString(value = 30,constraints = @Constraints(primaryKey = true))
    String handle;

    static int count;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }
    public static int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return handle;
    }
}
