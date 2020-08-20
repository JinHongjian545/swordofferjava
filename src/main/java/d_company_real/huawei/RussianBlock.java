package d_company_real.huawei;

import java.util.Scanner;

/**
 * @program: untitled
 * @description: 华为俄罗斯方块消除完还剩几行那个真题
 * @author: Jin Hongjian
 * @create: 2020-08-19
 **/
public class RussianBlock {

    public static void main(String[] args) {
        /*
         * 2122
         * 121
         * */
        Scanner scanner = new Scanner(System.in);
        String frameString = scanner.nextLine();
        String brickString = scanner.nextLine();

        int fLen = frameString.length();
        int bLen = brickString.length();

        int fMax = 0;
        int bMax = 0;
        int totalMax = 0;
        for (int i = 0; i < fLen; i++) {
            if (frameString.charAt(i) - '0' > fMax) {
                fMax = frameString.charAt(i) - '0';
            }
        }
        for (int i = 0; i < bLen; i++) {
            if (brickString.charAt(i) - '0' > bMax) {
                bMax = brickString.charAt(i) - '0';
            }
        }

        totalMax = fMax + bMax;
        boolean[][] frame = new boolean[frameString.length()][totalMax];
        boolean[][] brick = new boolean[brickString.length()][totalMax];

        //初始化frame
        for (int i = 0; i < fLen; i++) {
            for (int j = 0; j < frameString.charAt(i) - '0'; j++) {
                frame[i][j] = true;
            }
        }
        //初始化brick
        for (int i = 0; i < bLen; i++) {
            for (int j = 0; j < brickString.charAt(i) - '0'; j++) {
                brick[i][totalMax - 1 - j] = true;
            }
        }

        int result = Integer.MAX_VALUE;
        //遍历所有横向情况
        for (int i = 0; i < fLen - bLen + 1; i++) {
            //每次横向遍历重新复制frame数组
            boolean[][] frameLocal = new boolean[frameString.length()][fMax + bMax];
            for (int j = 0; j < frameString.length(); j++) {
                for (int k = 0; k < fMax + bMax; k++) {
                    frameLocal[j][k] = frame[j][k];
                }
            }


            //纵向找到最先接触点
            //i 表示横向开始点
            int max = 0;
            for (int j = 0; j < bLen; j++) {
                int c = frameString.charAt(i + j) - '0' + brickString.charAt(j) - '0';
                if (c > max) {
                    max = c;
                }
            }

            //合并
            int shift = totalMax - max;
            for (int j = 0; j < bLen; j++) {
                for (int k = max - 1; k >= 0; k--) {
                    frameLocal[i + j][k] = frameLocal[i + j][k] || brick[j][k + shift];
                }
            }
            //最后来统计下能消多少行
            int clearNum = 0;
            int totalNum = 0;

            for (int j = 0; j < totalMax; j++) {
                boolean clear = true;
                boolean allFalse = true;
                for (int k = 0; k < frameLocal.length; k++) {
                    if (frameLocal[k][j]) {
                        allFalse = false;
                    }
                    clear = clear && frameLocal[k][j];
                }
                if (allFalse) {
                    break;
                }
                if (clear) {
                    clearNum++;
                }
                totalNum++;
            }
            int cRes = totalNum - clearNum;
            if (result > cRes) {
                result = cRes;
            }
        }

        System.out.println(result);
    }


}

