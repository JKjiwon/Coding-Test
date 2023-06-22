package programers.lv1;

public class 다트게임 {
    public static void main(String[] args) {
        Solution023 s = new Solution023();
        System.out.printf("" + s.solution("1D2S#10S"));
    }
}

class Solution023 {
    public int solution(String dartResult) {
        int[] arr = new int[3];
        int idx = 0;
        String temp = "";
        int sum = 0;

        for (int i = 0; i < dartResult.length(); i++) {
            switch (dartResult.charAt(i)) {
                case '*':
                    arr[idx - 1] *= 2;
                    if (idx > 1) {
                        arr[idx - 2] *= 2;
                    }
                    break;
                case '#':
                    arr[idx - 1] *= -1;
                    break;
                case 'S':
                    arr[idx++] = Integer.parseInt(temp);
                    temp = "";
                    break;
                case 'D':
                    arr[idx++] = (int) Math.pow(Integer.parseInt(temp), 2);
                    temp = "";
                    break;
                case 'T':
                    arr[idx++] = (int) Math.pow(Integer.parseInt(temp), 3);
                    temp = "";
                    break;
                default: // 숫자 일때
                    temp += String.valueOf(dartResult.charAt(i));
                    break;
            }
        }
        for (int i = 0; i < 3; i++) {
            sum += arr[i];
        }
        return sum;
    }
}



