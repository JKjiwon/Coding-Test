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

        tree.preOrder();
        tree.inOrder();
        tree.postOrder();
    }
}

class Tree {
    Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public void preOrder() {
        System.out.print("전위 순회 출력 : ");
        preOrder(root);
        System.out.println();
    }

    public void inOrder() {
        System.out.print("중위 순회 출력 : ");
        inOrder(root);
        System.out.println();
    }

    public void postOrder() {
        System.out.print("후위 순회 출력 : ");
        postOrder(root);
        System.out.println();
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        printNode(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    private void printNode(Node node) {
        System.out.print(node.data + " ");
    }


    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        printNode(node);
        inOrder(node.right);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        printNode(node);
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