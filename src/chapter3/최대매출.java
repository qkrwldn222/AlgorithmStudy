package chapter3;

import java.util.Scanner;

/*

최대 매출
설명

현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.

만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면

12 15 11 20 25 10 20 19 13 15

연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.

여러분이 현수를 도와주세요.


입력
첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.

두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.


출력
첫 줄에 최대 매출액을 출력합니다.


예시 입력 1

10 3
12 15 11 20 25 10 20 19 13 15
예시 출력 1

56


 */
public class 최대매출 {
    public int solution(int n, int[] arr){
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < arr.length-n; i++){
//            int tmp = 0;
//            for (int j = i; j < i+n; j++){
//                tmp += arr[j];
//            }
//
//            max = Math.max(max,tmp);
//        }
//        return max; 매번 3개의 연속된 for문을 돌아야 해서 비효율적이다.

        // - > Sliding windows
        int answer = 0, sum = 0;
        for (int i = 0; i < n; i++){
            sum += arr[i];
            answer = sum;
        }
        for (int j = n; j < arr.length; j++){
            sum += arr[j] - arr[j-n];
            answer = Math.max(answer,sum);
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[d];
        for (int i = 0; i < d; i++ ){
            arr[i] = sc.nextInt();
        }
        System.out.println(new 최대매출().solution(n,arr));
    }
}
