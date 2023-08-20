package programmers.test2307.t0729;

public class Permutation {
	public static void main(String[] args) {
		int[] arr = {0, 1, 2}; //순열을 만들 배열
		int n = arr.length; //배열의 길이
		int[] output = new int[n]; //순열 출력을 위한 배열
		boolean[] visited = new boolean[n]; //중복해서 뽑지 않기 위해 방문했는지를 체크하는 배열

		System.out.println("\n-------- 2. DFS ---------");
		per2(arr, output, visited, 0, n, 2); //r = 3, 3개를 뽑을 것
	}

	//2. DFS를 이용해 구현  - 순서를 지키면서 n 개중에서 r 개를 뽑는 경우
	static void per2(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
		if (depth == r) {
			print(output, r); //순열 출력을 위한 print 함수
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i] != true) {
				visited[i] = true;
				output[depth] = arr[i];
				per2(arr, output, visited, depth + 1, n, r);
				visited[i] = false;
			}
		}
	}

	// 배열 출력
	static void print(int[] arr, int r) {
		for (int i = 0; i < r; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}
