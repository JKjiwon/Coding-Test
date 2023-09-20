import java.util.*;

class Main {
    public static void main(String[] args) {
        Main t = new Main();

        Node node4 = new Node(4, null, null);
        Node node5 = new Node(5, null, null);
        Node node2 = new Node(2, node4, node5);

        Node node3 = new Node(3, null, null);

        Node root = new Node(1, node2, node3);
        
        System.out.println(t.bfs(root));
        System.out.println(t.dfs(0, root));
    }

    public int bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                
                if (cur.left == null && cur.right == null) {
                    return level;
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            level++;
        }
        return -1;
    }

    public int dfs(int level, Node root) {
        if (root.left == null && root.right == null) {
            return level;
        }
        return Math.min(dfs(level + 1, root.left), dfs(level + 1, root.right));
    }

    static class Node {
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

