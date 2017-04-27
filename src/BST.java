import java.util.ArrayList;

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
        for (int i = 2; i < arr.length; i++)
            treeInsert(root, new TreeNode(arr[i]));
        return root;
    }

    public static int[] treeToArray(TreeNode<Integer> root) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1);
        int h = height(root);
        for (int i = 1; i <= h; i++)
            addGivenLevel(root, i, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = list.get(i).intValue();
        return res;
    }

    public static int findLargest(int[] arr, int k) {
        TreeNode root = arrayToTree(arr);
        ArrayList<Integer> list = new ArrayList<>();
        preOrder2(root, k, list);
        if (!list.isEmpty())
            return list.get(list.size()-1);
        else
            return -1;
    }

    public static void preOrder2(TreeNode root, int k, ArrayList<Integer> list) {
        if (root != null) {
            if (root.getData().compareTo(k) == 0) {
                list.add((Integer)root.getData());
                return;
            }
            else if (root.getData().compareTo(k) < 0) {
                if (root.getRightChild() != null) {
                    System.out.print("Right, ");
                    list.add((Integer)root.getData());
                }

                preOrder2(root.getRightChild(), k, list);
            } else {
                if (root.getLeftChild() != null) {
                    System.out.print("Left, ");
                    list.add((Integer)root.getData());
                }

                preOrder2(root.getLeftChild(), k, list);
            }
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

    public static void treeInsert(TreeNode root, TreeNode z) {
        TreeNode y = null;
        TreeNode x = root;

        while (x != null) {
            y = x;
            if (z.getData().compareTo(x.getData()) < 0)
                x = x.getLeftChild();
            else    x = x.getRightChild();
        }

        if (z.getData().compareTo(y.getData()) < 0)
            y.setLeftChild(z);
        else y.setRightChild(z);
    }

    public static int height(TreeNode root)
    {
        if (root == null)
            return 0;
        else
        {
            /* compute  height of each subtree */
            int lheight = height(root.getLeftChild());
            int rheight = height(root.getRightChild());

            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1);
        }
    }

    /* Print nodes at the given level */
    public static void addGivenLevel(TreeNode root, int level,ArrayList<Integer> list)
    {
        if (root == null)
            return;
        if (level == 1)
            list.add((Integer)root.getData());
        else if (level > 1)
        {
            addGivenLevel(root.getLeftChild(),level-1, list);
            addGivenLevel(root.getRightChild(),level-1, list);
        }
    }

    public static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.getData() + " ");
            preOrder(root.getLeftChild());
            preOrder(root.getRightChild());
        }
    }

    public static void inOrder(TreeNode<Integer> root) {
        if (root != null) {
            inOrder(root.getLeftChild());
            System.out.print(root.getData() + " ");
            inOrder(root.getRightChild());
        }
    }

    public static void main(String[] args) {
        int[] arr = {-1, 7, 4, 10, 3, 6, 8, 15};
        System.out.println(isValid(arr));

        int[] leaves = {10, 20, 30, 40};
        int[] res = buildTreeArray(leaves);
        for (int i : res)
            System.out.print(i + " ");
        System.out.println();

        TreeNode root = arrayToTree(arr);
        System.out.println("preorder: ");
        preOrder(root);
        System.out.println();
        System.out.println("inorder: ");
        inOrder(root);
        System.out.println("");

        int[] tToA = treeToArray(root);
        System.out.println("level order: ");
        for (int i : tToA)
            System.out.print(i + " ");
        System.out.println();

        System.out.println("findLargest");
        System.out.println(findLargest(arr, 5));
    }

}
