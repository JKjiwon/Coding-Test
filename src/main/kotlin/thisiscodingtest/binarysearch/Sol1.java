package thisiscodingtest.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
5
8 3 7 9 2
3
5 7 9
 */

// parts를 정렬하는데 드는 비용 O(NlogN)
// 이진 탐색을 통하여 정답을 구하는 비용 O(MlogN)
// 시간복잡도는 O((N+M)logN)
public class Sol1 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> parts = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).sorted().collect(Collectors.toList());

        int M = Integer.parseInt(br.readLine());
        List<Integer> finds = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());


        for (int find : finds) {
            String result = binarySearch(parts, find, 0, N - 1);
            System.out.println(result);
        }

    }

    public static String binarySearch(List<Integer> list, int target, int start, int end) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (list.get(mid) == target) {
                return "YES";
            } else if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return "NO";
    }

}
