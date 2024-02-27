package org.features.storage.strings;

public class IllustrationOfBuilder {
    public static void main(String[] args) {
        StringBuilder builder=new StringBuilder("Razak Mohamed S");
        builder.append(32);
        builder.append("Java Architect");
        builder.append(11);

        System.out.println(builder);

        builder.insert(15,"-");
        System.out.println(builder);

        builder.replace(18,23,"Technical");
        System.out.println(builder);

        builder.delete(36,38);
        System.out.println(builder);
    }
}
