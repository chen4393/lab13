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

    public static int[] buildTreeArray(int[] leaves) {
        int[] res = new int[2 * leaves.length];
        res[0] = -1;

        int j = res.length - 1;
        for (int i = leaves.length - 1; i >= 0; i--) {
            res[j] = leaves[i];
            j--;
        }

        for (int i = res.length - 2; i > 0; i -= 2) {
            res[i/2] = (res[i] + res[i+1]) / 2;
        }

        return res;
    }

    public static TreeNode<Integer> arrayToTree(int[] arr) {
        if (arr.length < 2)
            return null;
        TreeNode root = new TreeNode(arr[1]);
        TreeNode node = root;
        for (int i = 1; i < arr.length; i++) {
            TreeNode left = new TreeNode(arr[i], new TreeNode(arr[i+1]), new TreeNode(arr[i+2]));
        }
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
        int[] leaves = {10, 20, 30, 40};
        int[] res = buildTreeArray(leaves);
        for (int i : res)
            System.out.print(i + " ");
        System.out.println();
    }

}
