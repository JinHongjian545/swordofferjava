package d_bytedance_realquestion;

import java.util.*;

/**
 * 这里是找的实现，链接如下：
 * https://blog.csdn.net/qq_34385263/article/details/82026285?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase
 * @program: swordofferjava
 * @description:
 * @author: Jin Hongjian
 * @create: 2020-07-11
 *
【编码题】字符串S由小写字母构成，长度为n。定义一种操作，每次都可以挑选字符串中任意的两个相邻字母进行交换。询问在至多交换m次之后，字符串中最多有多少个连续的位置上的字母相同？
 这里采用的思想：
 （简单来说就是暴力算法...）
 1、先把每个字符出现的位置找到，保存到map中
 2、遍历1生成的map，对于其中保存的每一个索引，以它为移动中心，在移动部署不超过给定的m的情况下，得到一个最长的连续字母长度
    遍历完map的一个元素以后，就得到了这个元素拿来连接移动时，m步以内的最长连续长度
    遍历完整个map以后，就得到了所有元素的移动m步以内的最长连续长度，把这里面最大的一个返回即可
 **/
public class Main03 {

    public static void main(String[] args) {
        //abacccaka 3 ， abacccaka 4 ， abacccaka 8
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        int m = scanner.nextInt();
        System.out.println(getResult(string, m));
    }

    private static int getResult(String string, int m) {
        Map<Character, List<Integer>> map = new HashMap<>(64);
        //初始化map
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (map.containsKey(c)) {
                map.get(c).add(i);
            } else {
                List<Integer> list = new ArrayList<>(64);
                list.add(i);
                map.put(c, list);
            }
        }
        int maxLen = 1;
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {  //每个字符的遍历
            List<Integer> arrayList = entry.getValue();
            for (int i = 0; i < arrayList.size(); i++) { //单个字符出现的位置（索引）的遍历，表示以遍历到的这个位置为移动中心计算步数
                int ctr = arrayList.get(i);
                int[] move = new int[arrayList.size()];
                // 获取 move[]，表示每个相同字母到中心点 ctr 需要移动的最少步数
                for (int j = 0; j < arrayList.size(); j++) {
                    move[j] = (Math.abs(arrayList.get(j) - ctr) - Math.abs(i - j)); //注意这一步的计算
                }
                //注意此处必须排序，排序后，选择移动代价最少的前 k + 1 个
                Arrays.sort(move);
                int sum = 0;
                for (int k = 0; k < move.length; k++) {
                    sum += move[k]; //计算已经移动过总步数
                    if (sum > m) //步数超过了及时返回
                        break;
                    if (k + 1 > maxLen)
                        maxLen = k + 1;
                }
            }
        }
        return maxLen;

    }

}
