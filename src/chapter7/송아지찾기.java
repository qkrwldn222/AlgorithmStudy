package chapter7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*

송아지 찾기 1(BFS : 상태트리탐색)
설명

현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다.

현수의 위치와 송아지의 위치가 수직선상의 좌표 점으로 주어지면 현수는 현재 위치에서 송아지의 위치까지 다음과 같은 방법으로 이동한다.

송아지는 움직이지 않고 제자리에 있다.

현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다.

최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성하세요.


입력
첫 번째 줄에 현수의 위치 S와 송아지의 위치 E가 주어진다. 직선의 좌표 점은 1부터 10,000까지이다.


출력
점프의 최소횟수를 구한다. 답은 1이상이며 반드시 존재합니다.


예시 입력 1

5 14
예시 출력 1

3

 */
public class 송아지찾기 {
    static int[] bfs = {1,-1,5};
    static int[] chk = new int[10000];
    Queue<Integer> q = new LinkedList<>();

    public int solution(int n, int t){
        q.offer(n);
        chk[n] = 1;
        int L = 0;
        while (!q.isEmpty()){
            int len = q.size();
            for (int i = 0; i < len; i++){
                int pre = q.poll();
                for (int j = 0; j < 3; j++){
                    int nx = pre + bfs[j];
                    if (nx == t) return L+1;
                    if (nx >=1 && nx <= 10000 && chk[nx] == 0){
                        q.offer(nx);
                        chk[nx] = 1;
                    }
                }
            }
            L++;
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();

        System.out.println(new 송아지찾기().solution(n,t));
    }
}
