/**
 * Created by chen4393 on 4/25/17.
 */
public class BST {

    public static boolean isValid(int[] arr) {

        int k = (int)log2(arr.length);
        double kd = log2(arr.length);
        if (kd - k != 0)
            return false;

        for (int i = 1; i < arr.length; i++) {
            if (getLeft(i) < arr.length && getRight(i) < arr.length) {
                if (arr[getLeft(i)] > arr[i] || arr[getRight(i)] < arr[i]) {
                    //System.out.println("i: " + i);
                    return false;
                }
            }
        }

        return true;
    }

    public static double log2(int i) {
        return Math.log(i) / Math.log(2);
    }

    public static int getLeft(int i) {
        return 2 * i;
    }

    public static int getRight(int i) {
        return 2 * i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 7, 4, 10, 3, 6, 8, 15};
        System.out.println(isValid(arr));
    }

}
