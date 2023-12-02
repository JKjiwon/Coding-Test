import java.util.*;

public class Main {

    public static void main(String[] args) {
        Tree.Node n4 = new Tree.Node(4, null, null);
        Tree.Node n5 = new Tree.Node(5, null, null);
        Tree.Node n6 = new Tree.Node(6, null, null);
        Tree.Node n7 = new Tree.Node(7, null, null);

        Tree.Node n2 = new Tree.Node(2, n4, n5);
        Tree.Node n3 = new Tree.Node(3, n6, n7);
        Tree.Node n1 = new Tree.Node(1, n2, n3);

        Tree tree = new Tree(n1);

        int rs = tree.shortestPathToLeafNode();
        System.out.println(rs);
    }
}

class Tree {

    Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public int shortestPathToLeafNode() {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        int level = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node cur = q.poll();

                // 리프 노드 판별
                if (cur.left == null && cur.right == null) {
                    return level;
                }

                if (cur.left != null) {
                    q.offer(cur.left);
                }

                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            level++;
        }

        return -1;
    }

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}