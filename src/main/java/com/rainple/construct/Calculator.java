package com.rainple.construct;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculator {


    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        List<String> items = calculator.parseToSuffix("1+((2+3)*4-3)-5");
        System.out.println("后缀表达式为：" + items);
        int result = calculator.calculate(items);
        System.out.println("运算结果为： " + result);
    }

    public List<String> parseToSuffix(String expr) {
        List<String> items = parseExpr(expr);
        Stack<String> operateStack = new Stack<>();
        List<String> tmp = new ArrayList<>();
        int index = 0;
        int len = items.size();
        while (index < len) {
            String item = items.get(index);
            if (item.matches("\\d+")) {
                tmp.add(item);
            }else if (item.equals("(")) {
                operateStack.push(item);
            } else if (item.equals(")")) {
                while (!operateStack.peek().equals("(")) {
                    tmp.add(operateStack.pop());
                }
                operateStack.pop();
            } else {
                if (operateStack.isEmpty() || "(".equals(operateStack.peek())) {
                    operateStack.push(item);
                }else if (priority(item) > priority(operateStack.peek())) {
                    tmp.add(item);
                } else {
                    while (!operateStack.isEmpty() && priority(item) <= priority(operateStack.peek())) {
                        tmp.add(operateStack.pop());
                    }
                    operateStack.push(item);
                }
            }
            index++;
        }
        tmp.add(operateStack.pop());
        return tmp;
    }

    private int priority(String operateChar) {
        if ("*".equals(operateChar) || "/".equals(operateChar)) {
            return 2;
        }else if ("+".equals(operateChar) || "-".equals(operateChar)) {
            return 1;
        }else {
            //throw new RuntimeException("非法的操作符：" + operateChar);
            return 0;
        }
    }

    private List<String> parseExpr(String expression) {
        char[] chars = expression.toCharArray();
        int len = chars.length;
        List<String> items = new ArrayList<>(len);
        int index = 0;
        while (index < len) {
            char c = chars[index];
            if (c >= 48 && c <= 57) {
                String tmp = "";
                while (index < chars.length && chars[index] >= 48 && chars[index] <= 57) {
                    tmp += chars[index];
                    index++;
                }
                items.add(tmp);
            }else {
                items.add(c + "");
                index++;
            }
        }
        return items;
    }

    public int calculate(List<String> items) {
        Stack<String> stack = new Stack<>();
        for (String item : items) {
            if (item.matches("\\d+")) {
                stack.push(item);
            }else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res;
                switch (item) {
                    case "+" :
                        res = num1 + num2;
                        break;
                    case "-" :
                        res = num1 - num2;
                        break;
                    case "*" :
                        res = num1 * num2;
                        break;
                    case "/" :
                        res = num1 / num2;
                        break;
                    default:
                        throw new RuntimeException("非法的运算符：" + item);
                }
                stack.push("" + res);
            }
        }
        return Integer.parseInt(stack.pop());
    }

}
