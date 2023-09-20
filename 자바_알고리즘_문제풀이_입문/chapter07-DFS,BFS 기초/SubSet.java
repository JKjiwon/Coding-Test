class Main {
    
    static boolean[] ch;

    public static void main(String[] args) {
        Main t = new Main();
        int n = 3;
        ch = new boolean[4];
    
        t.dfs(1, n);

    }

    public void dfs(int start, int end) {
        if (start > end) {
            print(end);
            return;
        }

        ch[start] = true; // 포함하거나.
        dfs(start + 1, end);
        ch[start] = false; // 포함하지 않거나.
        dfs(start + 1, end);
    }

    public void print(int n) {
        String tmp = "";
        for (int i = 1; i <= n; i++) {
            if(ch[i]) {
                tmp += (i + " ");
            }
        }
        if(tmp.length() > 0) {
            System.out.println(tmp);
        }
    }
}