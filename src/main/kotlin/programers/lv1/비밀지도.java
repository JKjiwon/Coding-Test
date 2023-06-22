package programers.lv1;

public class 비밀지도 {
}

class Solution024 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            result[i] = convert(arr1[i] | arr2[i], n);
        }

        return result;
    }

    private String convert(int num, int n) {
        String result = Integer.toBinaryString(num);
        result = String.format("%-" + n + "s", result);
//        result = "0".repeat(n - result.length()) + result;
        return result.replace('0', ' ').replace('1', '#');
    }
}
