package chapter19enum;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/30
 * Mail:zhengjun1987@outlook.com
 */
public enum  OzWitch {
    WEST("观世音"),EAST("地藏王"),NORTH("普贤"),SOUTH("文殊师利");
    private String description;

    private OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for (OzWitch ozWitch : OzWitch.values()) {
            System.out.println("ozWitch.getDescription() = " + ozWitch.getDescription());
        }
//        ozWitch.getDescription() = 观世音
//        ozWitch.getDescription() = 地藏王
//        ozWitch.getDescription() = 普贤
//        ozWitch.getDescription() = 文殊师利
    }
}
