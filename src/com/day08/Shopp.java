package com.day08;

import java.util.ArrayList;
import java.util.Scanner;

/*
    超市管理系统主类
    实现：
       1、商品数据的初始化
       2、用户的菜单选择
       3、根据选择执行不同的功能
        3。1、Create 创建商品
        3。2、Update 修改商品
        3。3、Read 查看商品
        3。4、Delete 删除商品
 */
public class Shopp {

    public static void main(String[] args) {
        //创建一个集合，存储商品类型,存储数据类型为 FruitItem 类型
        ArrayList<FruitItem>  array = new ArrayList<FruitItem>();
        //调用商品初始化方法，传递集合
        init(array);
        while (true){
            //调用菜单方法
            mainMenu();
            //调用用户选择序号方法
            int choose = chooseFunction();
            switch (choose) {
                case 1:
                    //调用1：货物清单
                    showFruitList(array);
                    break;
                case 2:
                    addFruit(array);
                    //2：添加货物
                    break;
                case 3:
                    //3：删除货物
                    deleteFruit(array);
                    break;
                case 4:
                    updateFruit(array);
                    //4：修改清单
                    break;
                case 5:
                    //5:
                    return;
                    default:
                        System.out.println("输入的序号没有");
            }
        }
    }

    /**
     * 定义方法，实现商品的删除功能
     * 返回值：无
     * 参数：集合
     *
     * 提示用户选择的是修改功能
     * 提示用户输入需要修改的商品编号
     * 遍历集合，获取每个Fruititem变量
     * 变量调用ID属性，属性和用户输入的编号比较
     * 如果相同：
     *   修改掉FruitItem中的属性值
     *   键盘输入
     */
    public static void updateFruit(ArrayList<FruitItem> array){
        System.out.println("选择的是修改功能");
        System.out.println("请输入商品的编号");

        Scanner sc = new Scanner(System.in);
        int ID = sc.nextInt();

        for (int i = 0; i < array.size(); i++) {
            FruitItem item = array.get(i);
            if (item.ID == ID) {
                System.out.println("输入新的商品编号");
                item.ID = sc.nextInt();

                System.out.println("输入新的商品名字");
                item.name = sc.next();

                System.out.println("输入新的商品价格");
                item.price = sc.nextDouble();

                System.out.println("修改成功");
                return;
            }
        }
        System.out.println("您输入的编号不存在");
    }

    /**
     * 定义方法，实现商品的删除功能
     * 返回值：无
     * 参数：集合
     *
     * 删除依靠的是商品的编号
     * 提示用户选择的是删除功能
     * 键盘输入商品的编号
     * 遍历集合，获取集合中的每个FruitItem变量
     * 变量调用属性 ID,和用户的输入编号，对比，相同就删除
     */
    public static void deleteFruit(ArrayList<FruitItem> array) {
        System.out.println("选择的是删除功能");
        System.out.println("请输入商品的编号");
        Scanner sc = new Scanner(System.in);

        int ID = sc.nextInt();
        for (int i = 0; i < array.size(); i++) {
            FruitItem item = array.get(i);
            if (item.ID == ID) {
                //移除集合中的元素
                //集合的方法remove实现
                array.remove(i);
                System.out.println("删除成功");
                return;
            }
        }
        System.out.println("您输入的编号不存在");
    }

    /**
     * 定义方法，实现商品的添加功能
     * 返回值：无
     * 参数：集合
     * 提示用户选择的是添加商品的功能
     *
     * 提示用户输入的是什么
     *
     * 创建FruitItem变量，变量调用的属性
     * 将输入的每个商品属性进行赋值
     */
    public static void addFruit(ArrayList<FruitItem> array) {
        System.out.println("选择的是添加商品功能");
        //创建Scanner变量
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入商品的编号");
        //输入商品的编号
        int ID = sc.nextInt();
        //输入商品的名字
        System.out.println("请输入商品的名字");
        String name = sc.next();
        //输入商品的单价
        System.out.println("输入商品的单价");
        double price = sc.nextDouble();
        //创建FruitItem变量
        FruitItem item = new FruitItem();
        item.ID = ID;
        item.name = name;
        item.price = price;
        array.add(item);
        System.out.println("添加成功");
    }

    /**
     * 定义方法，实现显示货物清单功能
     * 返回值：无
     * 参数：集合
     * 遍历集合，获取集合中的每个FruitItem变量，调用属性
     */
    public static void showFruitList(ArrayList<FruitItem> array){
        System.out.println();
        System.out.println("========================商品库存清单========================");
        System.out.println("商品编号      商品名称      商品单价");
        //遍历集合
        for (int i = 0; i < array.size(); i++) {
            FruitItem item = array.get(i);
            System.out.println(item.ID+"      "+item.name+"      "+item.price);
        }
    }

    /**
     * 定义方法，实现接受用户的键盘输入
     * 返回编号
     */
    public static int chooseFunction(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    /**
     * 定义方法，实现主菜单
     * 提示用户有哪些选项
     * 返回值：无
     */
    public static void mainMenu(){
        System.out.println();
        System.out.println("===============欢迎光临ItCast超市==================");
        System.out.println("1：货物清单  2：添加货物  3：删除货物  4：修改货物  5：退出");
        System.out.println("请您输入要操作的功能序号");
    }

    /**
     * 定义方法，实现商品数据的初始化
     * 先将一部分数据，存储集合中
     * 返回值：无
     * 参数：集合
     * 方法名：init
     */
    public static void init(ArrayList<FruitItem> array){
        //创建出多个 FruitItem 类型，并且属性赋值
        FruitItem f1 = new FruitItem();
        f1.ID = 9527;
        f1.name = "少林寺酥饼核桃";
        f1.price = 12.7;

        FruitItem f2 = new FruitItem();
        f2.ID = 9008;
        f2.name = "尚康杂粮牡丹饼";
        f2.price = 5.6;

        FruitItem f3 = new FruitItem();
        f3.ID = 9879;
        f3.name = "新疆原产哈密瓜";
        f3.price = 599.6;

        array.add(f1);
        array.add(f2);
        array.add(f3);

    }


}
