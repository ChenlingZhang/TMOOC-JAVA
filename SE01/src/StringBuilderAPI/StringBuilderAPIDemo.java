package StringBuilderAPI;

public class StringBuilderAPIDemo {
    public static void main(String[] args) {
        String str = "good good study";
        StringBuilder stringBuilder = new StringBuilder(str);
        // 增
        stringBuilder.append(" have a good life");
        System.out.println("StringBuilder 增加操作: " + stringBuilder);
        // 改
        stringBuilder.replace(str.length(),stringBuilder.length()," have a good feture");
        System.out.println("StringBuilder 改写操作: " + stringBuilder);
        // 删
        stringBuilder.delete(0,5);
        System.out.println("StringBuilder 删除操作: " + stringBuilder);
        // 插
        stringBuilder.insert(0,"good ");
        System.out.println("StringBuilder 插入操作: " + stringBuilder);

        // 反转字符串
        stringBuilder.reverse();
        System.out.println("StringBuilder 反转字符: " + stringBuilder);
    }
}
