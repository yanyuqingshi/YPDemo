
/*
    引用数据类型，介绍一个类  Scanner
    java已经存在了，是sun公司为我们做好的类，使用它
    定义引用数据类型变量，和基本类型变量区别
    int a = 1;
    格式：
    类型  变量名 = new 类型();
    举例：创建出Scanner类的变量
        Scanner s = new Scanner();
        int a = 1;
    每个引用类型，都有自己的功能，如何使用功能
    公式：
    变量.功能名字();


    Scanner类，作用，让我们在命令行中，接收键盘的输入
    使用Scanner类步骤：
        1、导入包,指明类所在的文件夹
            java文件夹-util文件夹
        2、公式，创建出Scanner类型变量
        3、变量.使用Scanner类中的功能，完成键盘输入
 */
package com.company;
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //变量.功能名字()  接受键盘输入
        //功能：nextInt() 接受键盘输入，保证输入的是整数
        //功能接受的数据就是整数，功能运行后的结果就是整数类型
        int i = sc.nextInt();
        System.out.println(i+1);

        //Scanner 类的另一个功能  next() 接受键盘输入的字符串
        String str = sc.next();
        System.out.println(str);

    }
}
