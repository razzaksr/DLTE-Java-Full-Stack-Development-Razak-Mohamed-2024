package org.dynamic.framework;

import java.util.Stack;

public class IllustrationStack {
    public static void main(String[] args) {
        Stack<String> stringStack=new Stack<>();
        stringStack.push("Education Loan");
        stringStack.push("Vehicle Loan");
        stringStack.push("Personal Loan");
        stringStack.push("Property against Loan");
        stringStack.push("Gold Loan");
        stringStack.push("Housing Loan");
        stringStack.push("Business Loan");

        System.out.println(stringStack.peek());

        stringStack.pop();

        System.out.println(stringStack);

        System.out.println(stringStack.search("Business Loan"));

        stringStack.clear();
        System.out.println(stringStack.isEmpty());
    }
}
