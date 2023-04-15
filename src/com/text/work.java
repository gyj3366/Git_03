package com.text;

import java.util.Scanner;
import java.util.Stack;
public class work {
    //输入运算符优先关系，存放不同级的符号优先级关系
    static char[][] priorityTable = {
            {'>', '>', '<', '<', '<', '<', '>'},
            {'>', '>', '<', '<', '<', '<', '>'},
            {'>', '>', '>', '>', '<', '<', '>'},
            {'>', '>', '>', '>', '<', '<', '>'},
            {'>', '>', '>', '>', '>', '<', '>'},
            {'<', '<', '<', '<', '<', '<', '='},
            {'>', '>', '>', '>', '>', ' ', '>'}
    };

    public static void main(String[] args){
        postOrder();
    }

    public static void postOrder (){
        //栈用以存放符号
        Stack<Character> stack = new Stack<>();
        //输入中缀表达式
        System.out.println("输入中缀表达式:");
        Scanner sc = new Scanner(System.in);
        String strings = sc.nextLine();
        System.out.println(strings);
        System.out.println("逆波兰表达式:");
        if (strings != null && strings.length() != 0 ) {
            for (int i = 0; i < strings.length(); i++) {
                char ch = strings.charAt(i);
                stringEmpty(ch, stack);
                if (i == strings.length() - 1) {
                    stackIsEmpty(stack);
                    System.out.println();
                }
            }
        } else {
            return;
        }
    }

    //输入串不为空
    public static void stringEmpty(char ch, Stack<Character> stack){
        //判断是否是运算符
        if (index(ch) == -1) {
            System.out.print(ch);
        }else if (stack.isEmpty()) { //入 栈
            stack.push(ch);
            return;
        }else { //比较当前运算符于栈顶运算符的优先级
            compare(ch, stack);
        }
    }

    public static void stackIsEmpty(Stack<Character> stack) {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }

    /**
     *      比较当前运算符于栈顶运算符的优先级
     */
    public static void compare(char ch, Stack<Character> stack){

        if (stack.isEmpty()) {
            stack.push(ch);
        } else {
            char cmp = priorityTable[index(stack.peek())][index(ch)];
            switch (cmp) {
                case '<':
                    stack.push(ch);
                    break;
                case '=':
                    stack.push(ch);
                    break;
                case '>':
                    if (ch == ')') {
                        //当前运算符是')'
                        stackTop(stack);
                    } else {
                        System.out.print(stack.pop());
                        compare(ch, stack);
                    }
                    break;
                default:
                    return ;
            }
        }
    }

    public static void stackTop(Stack<Character> stack){
        if (stack.peek() == '('){
            stack.pop();
        } else if (stack.isEmpty()) {
            System.out.println("error");
        } else {
            System.out.print(stack.pop());
            stackTop(stack);
        }
    }

    /**
     * 给定字符串返回在优先级表中的索引
     */

    public static int index(char c) {
        switch (c) {
            case '+':
                return 0;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 3;
            case '↑':
                return 4;
            case '(':
                return 5;
            case ')':
                return 6;
            default:
        }
        return -1; //代表数字
    }
}