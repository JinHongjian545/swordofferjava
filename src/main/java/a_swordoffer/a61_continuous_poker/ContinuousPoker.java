package a_swordoffer.a61_continuous_poker;

import java.util.Arrays;

/**
 * 判断扑克牌中的顺子，大小王为0， 可以随便变，三个步骤
 * 1.数组排序
 * 2.统计数组中0的个数
 * 3.统计排序后数组中相邻元素中空缺的个数，如果小于等于0的个数则满足条件，另外如果两张牌相同，则不可能为顺子
 */
public class ContinuousPoker {
    boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length != 5) {
            return false;
        }
        Arrays.sort(numbers); //排完序以后0自然就在最前面了
        int numsOf0 = 0;
        int numsOfGap = 0;
        for (int i = 0; i < numbers.length && numbers[i] == 0; i++) {
            ++numsOf0;
        }
        for (int i = numsOf0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) { //存在对子
                return false;
            }
            numsOfGap += (numbers[i + 1] - numbers[i] - 1);
        }
        return numsOf0 >= numsOfGap;
    }

}
