import java.util.*;
class Node
{
    int x, y, val;
    Node left,right;

    public Node(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
class Solution {
    static List<Node> tree;
    static int orderIdx;
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer;

        int nodeInfo_row = nodeinfo.length;
        tree = new ArrayList<>();

        for (int i = 0; i < nodeInfo_row; i++) {
            int x = nodeinfo[i][0];
            int y = nodeinfo[i][1];

            tree.add(new Node(x, y, i + 1));
        }
        tree.sort((o1, o2) -> o2.y - o1.y); // y를 기준으로 내림차순

        Node root = tree.get(0);

        int tree_size = tree.size();
        for (int i = 1; i < tree_size; i++) {
            link(root, tree.get(i));
        }

        answer = new int[2][nodeInfo_row];
        //전위
        preOrder(root, answer[0]);
        orderIdx = 0;
        //후위
        postOrder(root, answer[1]);
        return answer;
    }
    static void link(Node parent, Node child) {
        // 왼쪽
        if (parent.x > child.x) {
            //왼쪽이 비어있으면
            if (parent.left == null) {
                parent.left = child;
            }
            // 이미 채워져있으면
            else {
                link(parent.left, child);
            }
        }
        // 오른쪽
        else {
            if (parent.right == null) {
                parent.right = child;
            }
            else {
                link(parent.right, child);
            }
        }
    }

    static void preOrder(Node node, int [] arr) {
        if (node != null) {
            arr[orderIdx++] = node.val;
            preOrder(node.left, arr);
            preOrder(node.right, arr);
        }
    }

    static void postOrder(Node node, int [] arr) {
        if (node != null) {
            postOrder(node.left, arr);
            postOrder(node.right, arr);
            arr[orderIdx++] = node.val;
        }
    }
}