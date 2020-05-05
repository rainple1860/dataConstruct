package com.rainple.construct;

import com.rainple.construct.stack.LinkStack;
import com.rainple.construct.stack.Stack;

import java.util.ArrayList;
import java.util.List;

public class Calculator {


    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        List<String> items = calculator.midfixToSuffix("(3+4)*5-6");
        System.out.println("后缀表达式为：" + items);
        int result = calculator.calculate(items);
        System.out.println("运算结果为： " + result);
    }

    /**
     * 1）初始化两个栈：运算符栈operateStack和储存中间结果的栈tmp；
     * 2）从左至右扫描中缀表达式；
     * 3）遇到操作数时，将其压tmp；
     * 4）遇到运算符时，比较其与operateStack栈顶运算符的优先级：
     * 　　4.1）如果operateStack为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
     * 　　4.2）否则，若优先级比栈顶运算符的高，也将运算符压入operateStack；
     * 　　4.3）否则，将operateStack栈顶的运算符弹出并压入到tmp中，再次转到(4-1)与operateStack中新的栈顶运算符相比较；
     * 5）遇到括号时：
     * 　　5.1) 如果是左括号“(”，则直接压入operateStack
     * 　　5.2) 如果是右括号“)”，则依次弹出operateStack栈顶的运算符，并压入tmp，直到遇到左括号为止，此时将这一对括号丢弃
     * 6）重复步骤2至5，直到表达式的最右边
     * 7）将operateStack中剩余的运算符依次弹出并压入tmp
     * 8）依次弹出tmp中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
     * @param expr 中缀表达式
     * @return 后缀表达式
     */
    public List<String> midfixToSuffix(String expr) {
        /**
         * 将表达式的操作数和运算符转换成集合
         */
        List<String> items = parseExpr(expr);
        //操作数栈
        Stack<String> operateStack = new LinkStack<>();
        //临时变量的保存集合，这里使用了List集合
        //如果用栈也可以实现，但是需要在最后将弹出栈元素的逆序进行运算
        //所以使用List集合避免了这个转换的问题
        List<String> tmp = new ArrayList<>();
        //操作的位置
        int index = 0;
        //表达式长度
        int len = items.size();
        while (index < len) {
            String item = items.get(index);
            //遇到操作数时，将其压tmp；
            if (item.matches("\\d+")) {
                tmp.add(item);
            }else if (item.equals("(")) {//如果是左括号“(”，则直接压入operateStack
                operateStack.push(item);
            } else if (item.equals(")")) {//如果是右括号“)”，则依次弹出operateStack栈顶的运算符，并压入tmp，直到遇到左括号为止，此时将这一对括号丢弃
                while (!operateStack.peek().equals("(")) {
                    tmp.add(operateStack.pop());
                }
                //直接弹出栈顶元素即可
                operateStack.pop();
            } else {//遇到运算符时，比较其与operateStack栈顶运算符的优先级
                //如果operateStack为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
                if (operateStack.isEmpty() || "(".equals(operateStack.peek())) {
                    operateStack.push(item);
                }else if (priority(item) > priority(operateStack.peek())) {//否则，若优先级比栈顶运算符的高，也将运算符压入operateStack；
                    tmp.add(item);
                } else {//否则，将operateStack栈顶的运算符弹出并压入到tmp中，再次转到(4-1)与operateStack中新的栈顶运算符相比较；
                    while (!operateStack.isEmpty() && priority(item) <= priority(operateStack.peek())) {
                        tmp.add(operateStack.pop());
                    }
                    //将运算符压入栈
                    operateStack.push(item);
                }
            }
            //没一轮结束需要将操作位置往后移动一位
            index++;
        }
        //解析结束后需要将剩下的栈元素全部弹出来放入到tmp中
        while (!operateStack.isEmpty()) {
            tmp.add(operateStack.pop());
        }
        return tmp;
    }

    /**
     * 获取运算符的优先级，数字越大优先级越大
     * @param operateChar 运算符
     * @return 优先级
     */
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

    /**
     * 将表达式解析成List
     * @param expression 表达式
     * @return
     */
    private List<String> parseExpr(String expression) {
        char[] chars = expression.toCharArray();
        int len = chars.length;
        List<String> items = new ArrayList<>(len);
        int index = 0;
        while (index < len) {
            char c = chars[index];
            //数字
            if (c >= 48 && c <= 57) {
                String tmp = "";
                //操作数大于一位数，主要是通过判断下一位是否为数字
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

    /**
     * 根据后缀表达式计算值
     * @param items 后缀表达式
     * @return 计算结果
     */
    public int calculate(List<String> items) {
        /**
         * 用于保存过程变量和操作符等
         */
        Stack<String> stack = new LinkStack<>();
        //便利
        for (String item : items) {
            //如果为数字，直接放入栈中
            if (item.matches("\\d+")) {
                stack.push(item);
            }else {
                //弹出栈顶元素进行运算
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
                //运算完将结果压入栈中
                stack.push("" + res);
            }
        }
        //整个表达式扫描结束后，此时栈中只剩一个元素，该元素即为结算结果，从栈中弹出即可
        return Integer.parseInt(stack.pop());
    }

}
