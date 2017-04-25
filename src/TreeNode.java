/**
 * Created by chen4393 on 4/25/17.
 */
// This is a class for Binary Search Tree nodes
public class TreeNode<E extends Comparable<E>> {

    // Member Data
    private E data;
    private TreeNode<E> leftChild;
    private TreeNode<E> rightChild;

    // Constructors
    public TreeNode(E data, TreeNode<E> leftChild, TreeNode<E> rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public TreeNode() {
        this(null, null, null);
    }

    public TreeNode(E data) {
        this(data, null, null);
    }

    public TreeNode(E data, TreeNode<E> leftChild) {
        this(data, leftChild, null);
    }

    // Getters and setters
    public E getData() {
        return this.data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public TreeNode<E> getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(TreeNode<E> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<E> getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(TreeNode<E> rightChild) {
        this.rightChild = rightChild;
    }
}
