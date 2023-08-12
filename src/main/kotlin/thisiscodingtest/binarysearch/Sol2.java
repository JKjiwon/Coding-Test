package thisiscodingtest.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 이진 탐색
// 떡의 길이가 목표 길이보다 클때, 정답(answer) 업데이트
public class Sol2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);
        List<Integer> breads = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int result = findHeight(breads, M, 0, breads.stream().mapToInt(it -> it).max().getAsInt());
        System.out.println(result);
    }

    private static int findHeight(List<Integer> breads, int target, int start, int end) {
        int answer = 0;
        int left = start;
        int right = end;

        while (left <= right) {
            int mid = (left + right) / 2;
            int breadAmount = getBreadAmount(breads, mid);

            if (breadAmount >= target) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    private static int getBreadAmount(List<Integer> breads, int sliceHeight) {
        return breads.stream().filter(bread -> bread > sliceHeight).mapToInt(bread -> bread - sliceHeight).sum();
    }
}
