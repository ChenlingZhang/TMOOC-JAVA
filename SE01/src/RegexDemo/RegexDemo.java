package RegexDemo;

import java.util.Arrays;

public class RegexDemo {
    public static void main(String[] args) {
        //----------正则判断String是否符合规范
        String email = "1234567@qq.com";
        String regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+";
        boolean isMatch = email.matches(regex); // 判断传入的正则表达式的格式是否与邮箱格式匹配
        if (isMatch){
            System.out.println("This is an email address");
        }
        else System.out.println("This is not an email address");
        //---------正则切分字符串
        String str = "abc123def456ghi";
        String[] string_split = str.split("[0-9]+");
        System.out.println(Arrays.toString(string_split));

        //--------正则表达式和谐字符串replaceAll
        String regex2 = "(sb|nmb|qnmd|cnm|nt|w2|dsb)";
        String language = "qnmd你个dsb铁nt";
        language = language.replaceAll(regex2,"***");
        System.out.println(language);


    }
}
