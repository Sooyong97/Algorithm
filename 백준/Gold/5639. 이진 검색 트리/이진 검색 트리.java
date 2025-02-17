import java.util.*;
import java.io.*;

public class Main {
    static class binaryTree {
        int root;
        binaryTree left, right;

        binaryTree(int root) {
            this.root = root;
        }

        void insertNode(int value) {
            if (value < this.root) {
                if (this.left == null) this.left = new binaryTree(value);
                else this.left.insertNode(value);
            }
            if (value > this.root) {
                if (this.right == null) this.right = new binaryTree(value);
                else this.right.insertNode(value);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int root = Integer.parseInt(br.readLine());
        binaryTree tree = new binaryTree(root);
        String s;

        while (true) {
            s = br.readLine();
            if (s == null || s.equals("")) break;
            int value = Integer.parseInt(s);
            tree.insertNode(value);
        }

        postOrderTraverse(tree);
    }

    private static void postOrderTraverse(binaryTree tree) {
        if (tree.left != null) postOrderTraverse(tree.left);
        if (tree.right != null) postOrderTraverse(tree.right);
        System.out.println(tree.root);
    }
}