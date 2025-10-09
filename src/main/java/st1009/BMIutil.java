package st1009;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * BMIutil 類別：提供 BMI 計算及分類功能。
 */
public class BMIutil {

    /**
     * 程式進入點：從標準輸入讀取體重和身高，計算並顯示 BMI 及分類結果。
     * @param args
     */
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("輸入體重：");
            final double weight = input.nextDouble();
            System.out.print("輸入身高：");
            final double height = input.nextDouble();

            final BMIutil bmiUtil = new BMIutil();
            final Map<String, Double> result = bmiUtil.bmiCounter(weight, height);
            System.out.println(result);
        }
    }


    /**
     * 建構子：初始化 BMIutil 物件，並顯示啟動訊息。
     */
    public BMIutil(){
        System.out.println("BMI 計算 啟動");
    }


    /**
     * 根據輸入的體重（公斤）和身高（公分）計算 BMI，並判斷體重分類。
     * @param weight 體重（公斤）
     * @param height 身高（公分）
     * @return 包含體重分類及 BMI 值的 Map
     */
    public Map<String, Double> bmiCounter(final double weight, final double height) {
        final String result;
        final double bmi = Math.round(weight / (height/100 * height/100) * 100.0) / 100.0;
        final Map<String, Double> map = new ConcurrentHashMap<>();

        final boolean isUnderWeight = bmi < 18.5;
        final boolean isNormalWeight = bmi >= 18.5 && bmi < 25;
        final boolean isOverWeight = bmi >= 25;

        if (isUnderWeight) {
            result = "體重過輕";
        } else if (isNormalWeight) {
            result = "健康體重";
        } else if (isOverWeight) {
            result = "體重過重";
        } else {
            result = "啊～「肥胖」";
        }
        // `final` 只保證變數 `result` 不能被重新賦值為另一個物件（對於物件型別），
        // 但對於基本型別（如 `String`），`final` 保證只能被賦值一次。
        // 在這程式碼中，`result` 是在 if-else 區塊內第一次被賦值，且只會賦值一次，所以是合法的。
        // 如果嘗試在 if-else 區塊外再次賦值，就會編譯錯誤。

        map.put("你是" + result + "，BMI", bmi);

        return map;
    }

}
