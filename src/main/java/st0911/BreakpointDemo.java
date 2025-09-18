package st0911;

import java.util.Scanner;

public class BreakpointDemo {

    public static void main(String[] args) {
        System.out.println("要");
        System.out.println("跳");
        System.out.println("過");
        System.out.println("嗎");

        BreakpointDemo b = new BreakpointDemo();

        b.computeArea();

        System.out.println("安");
        System.out.println("安");
        System.out.println("你");
        System.out.println("好");
        // resume 是直接跳到下一個中斷點，但重點在恢復執行，只是因為我有設定下一個中斷點，所以會跳到下一個
        // step into 一行一行執行，最單純
        // step over 跳過方法（但方法會執行，只是直接執行，不會進去方法內一步一步走）
    }

    public BreakpointDemo() {
        System.out.println("建構子");
    }

    public static void computeArea() {
//        Scanner input = new Scanner(System.in);
//        System.out.print("Enter diameter: ");
//        int diameter = input.nextInt();

        int diameter = 10;

        double area = Math.PI * Math.pow(diameter / 2, 2);
        System.out.println("diameter: " + diameter);
        System.out.println("area: " + area);
    }
}