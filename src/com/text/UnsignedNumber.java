package com.text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UnsignedNumber {

    public static void main(String[] args) throws IOException {
        fun();

    }

    public static void fun() throws IOException {
        System.out.print("输入符号串:(最后以\";\"结束):");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strings = br.readLine();

        if (strings.length() == 0 || strings == null) {
            System.out.println("error!");
            return;
        } else {
            int w = 0; // 尾数累加器
            int p = 0; // 指数累加器
            int j = 0; // 十进制小数位数计数器
            int e = 1; // 记录十进制数的符号
            String CJ1; //记录类型
            float Cj2;
            for (int i = 0; i < strings.length(); i++) {
                char ch = strings.charAt(i);
                int d;
                if (i == 0) {
                    if (ch > 48 && ch < 58) { //数字  1-9
                        d = ch - 48; //数值 => d
                        w = w * 10 + d; //w*10+d=>w
                    } else {
                        System.out.println("error!");
                        return;
                    }
                } else {
                    if (ch > 47 && ch < 58) { //数字  0-9
                        d = ch - 48; //数值 => d
                        w = w * 10 + d; //w*10+d=>w
                    } else {
                        if (ch == '.') {  //是否是小数点
                            i++;
                            ch = strings.charAt(i); //取下一个字符
                            if (ch < 48 || ch > 58) { //不是数字
                                System.out.println("error!");
                                return;
                            } else { //数字 0-9
                                do {
                                    d = ch - 48; //数值 => d
                                    w = w * 10 + d; //w*10+d=>w
                                    j += 1; //j+1=>j
                                    i++;
                                    ch = strings.charAt(i); //取下一个字符
                                } while (ch > 47 && ch < 58);
                                if (ch == 'E') { //是'E'否
                                    i++;
                                    ch = strings.charAt(i); //取下一个字符
                                    if (ch == '-') { //是'-'否
                                        e = -1;
                                        i++;
                                        ch = strings.charAt(i); //取下一个字符
                                    } else if (ch == '+') { //是'+'否
                                        i++;
                                        ch = strings.charAt(i); //取下一个字符
                                    }

                                    if (ch < 48 || ch > 58) { //不是数字
                                        System.out.println("error!");
                                        return;
                                    } else {
                                        do {
                                            d = ch - 48; //数值 => d
                                            p = p * 10 + d; //p*10+d=>p
                                            i++;
                                            ch = strings.charAt(i); //取下一个字符
                                        } while (ch > 47 && ch < 58);

                                        CJ1 = "实型";
                                        Cj2 = (float) (w * Math.pow(10.0, e * p - j));
                                        System.out.println(CJ1 + "_" + Cj2);
                                        return;
                                    }
                                } else {
                                    CJ1 = "实型";
                                    Cj2 = (float) (w * Math.pow(10.0, e * p - j));
                                    System.out.println(CJ1 + "_" + Cj2);
                                    return;
                                }
                            }

                        } else {
                            if (ch == 'E') {  //是否是E
                                i++;
                                ch = strings.charAt(i); //取下一个字符
                                if (ch == '-') { //是'-'否
                                    e = -1;
                                    i++;
                                    ch = strings.charAt(i); //取下一个字符
                                } else if (ch == '+') { //是'+'否
                                    i++;
                                    ch = strings.charAt(i); //取下一个字符
                                }

                                if (ch < 48 || ch > 58) { //不是数字
                                    System.out.println("error!");
                                    return;
                                } else {
                                    do {
                                        d = ch - 48; //数值 => d
                                        p = p * 10 + d; //p*10+d=>p
                                        i++;
                                        ch = strings.charAt(i); //取下一个字符
                                    } while (ch > 47 && ch < 58);

                                    CJ1 = "实型";
                                    Cj2 = (float) (w * Math.pow(10.0, e * p - j));
                                    System.out.println(CJ1 + "_" + Cj2);
                                    return;
                                }
                            } else {
                                CJ1 = "整型";
                                Cj2 = (float) (w * Math.pow(10.0, e * p - j));
                                System.out.println(CJ1 + "_" + Cj2);
                            }
                        }
                    }
                }

            }
        }
    }
}
