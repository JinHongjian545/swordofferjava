package a_swordoffer.a_66_array_without_divide;

import java.util.Arrays;

/**
 * 不适用除法构建乘积数组
 */
public class ArrayWithoutDivide {
    /**
     * B[i] = A[0]* ... *A[i-1] * A[i+1]*...A[n-1]
     * C[i] = A[0]* ... *A[i-1]
     * D[i] = A[i+1]*...*A[n-1]
     * B[i] = C[i]*D[i]
     *
     * @param A
     * @return
     */
    public static int[] arrayWithoutDivide(int[] A) {
        if (A == null) {
            return null;
        }
        int len = A.length;
        int[] B = new int[len]; //要返回的结果
        int[] C = new int[len];
        int[] D = new int[len];
        //首先计算C和D数组
        C[0] = 1;
        for (int i = 1; i < len; i++) {
            C[i] = C[i - 1] * A[i - 1];
        }
        D[len - 1] = 1;
        B[len - 1] = C[len - 1] * D[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            D[i] = D[i + 1] * A[i+1];
            B[i] = C[i] * D[i];
        }
        return B;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        int[] ints = arrayWithoutDivide(nums);
        System.out.println(Arrays.toString(ints));

    }

}
