import java.util.*;

class Main {

    public static void main(String[] args) {

        Node node4 = new Node(4, null, null);
        Node node5 = new Node(5, null, null);
        Node node2 = new Node(2, node4, node5);

        Node node6 = new Node(6, null, null);
        Node node7 = new Node(7, null, null);
        Node node3 = new Node(3, node6, node7);

        Node root = new Node(1, node2, node3);

        System.out.print("전위 순회: ");
        root.preOrder();
        System.out.print("중위 순회: ");
        root.inOrder();
        System.out.print("후위 순회: ");
        root.postOrder();

        System.out.println("BFS");
        root.bfs();

    }
    
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(this);
        int L = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            System.out.print(L + ": ");
            for(int i = 0; i < len; i++) {
                Node cur = queue.poll();
                System.out.print(cur.data + " ");

                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            L++;
            System.out.println();
        }

        System.out.println();
    }

    public void inOrder() {
        inOrder(this);
        System.out.println();
    }

    public void preOrder() {
        preOrder(this);
        System.out.println();
    }

    public void postOrder() {
        postOrder(this);
        System.out.println();
    }

    private void preOrder(Node node) {
        if(node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }


    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    private void postOrder(Node node) {
        if(node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

}