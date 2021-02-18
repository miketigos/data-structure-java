package dataStructuresJava;

/**
 * @author Michael Thomas
 * Binary search tree implemetation
 * This can be made to take any type of data that implements the comparable interface
 */

public class BST<T extends Comparable<T>>{

    private BSTNode root;

    public BST() {
        this.root = null;
    }

    private class BSTNode {
        T data;
        BSTNode left = null;
        BSTNode right = null;

        public BSTNode() {}

        public BSTNode(T data) {
            this.data = data;
        }
        public BSTNode(T data, BSTNode left, BSTNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public void insert(T data) {
        root = insertRecursive(root, data);
    }

    public BSTNode insertRecursive(BSTNode node, T data) {
        if (node == null) {
            node = new BSTNode(data);
            return node;
        }
        if (data.compareTo(node.data) < 0) {
            node.left = insertRecursive(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insertRecursive(node.right, data);
        }
        return node;
    }

    public void delete(T value) {
        root = deleteRecursive(root, value);
    }

    public BSTNode deleteRecursive(BSTNode root, T value) {
        if (root == null) {
            return root;
        }
        //traverse tree
        if (value.compareTo(root.data) < 0) {
            root.left = deleteRecursive(root.left, value);
        } else if (value.compareTo(root.data) > 0) {
            root.right = deleteRecursive(root.right, value);
        } else {    
            // check the different cases for number of children target node has
            //node has only one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // find lowest value from right subtree
            root.data = getMinValue(root.right);
            // delete inorder successor
            root.right = deleteRecursive(root.right, root.data);
        }
        return root;
    }

    public T getMinValue(BSTNode node) {
        
        T minValue = node.data;

        while(node.left != null) {
            minValue = node.left.data;
            node = node.left;
        }
        return minValue;
    }

    public void inOrderTraversal() {
        inOrderRecursive(root);
    }

    public void inOrderRecursive(BSTNode node) {
        if (node != null) {
            inOrderRecursive(node.left);
            System.out.print(node.data +  " ");
            inOrderRecursive(node.right);
        }
    }

    public void preOrderTraversal() {
        preOrderRecursive(root);
    }

    public void preOrderRecursive(BSTNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderRecursive(node.left);
            preOrderRecursive(node.right);
        }
    }

    public void postOrderTraversal() {
        postOrderRecursive(root);
    }

    public void postOrderRecursive(BSTNode node) {
        if (node != null) {
            postOrderRecursive(node.left);
            postOrderRecursive(node.right);
            System.out.print(node.data + " ");

        }
    }

}

