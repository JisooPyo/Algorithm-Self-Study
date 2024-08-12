package algorithm.unionFind;

import java.util.Scanner;

class UnionFind {
    private int[] parent;
    private int[] rank;

    // 초기화: 각 원소는 자기 자신을 부모로 가짐
    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    // Find: 경로 압축을 사용하여 루트 노드를 찾음
    public int find(int p) {
        if (parent[p] != p) {
            parent[p] = find(parent[p]);  // 경로 압축
        }
        return parent[p];
    }

    // Union: 랭크를 기준으로 두 집합을 합침
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        // rooP와 rootQ가 같다는 것은 같은 부모를 가진 집합에 속한다는 것을 뜻함.
        // 다르다는 것은 서로 다른 집합에 속한다는 것을 뜻함
        if (rootP != rootQ) {
            if (rank[rootP] > rank[rootQ]) {    // 랭크가 낮은 트리를 높은 트리에 붙임
                parent[rootQ] = rootP;
            } else if (rank[rootP] < rank[rootQ]) { // 랭크가 낮은 트리를 높은 트리에 붙임
                parent[rootP] = rootQ;
            } else {    // 랭크가 같은 경우, 임의로 하나를 다른 쪽에 붙이고 랭크를 1 증가
                parent[rootQ] = rootP;
                rank[rootP]++;
            }
        }
    }

    // 두 원소가 같은 집합에 속하는지 확인
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int n = sc.nextInt();
        int m = sc.nextInt();

        UnionFind uf = new UnionFind(n);

        // 친구 관계 입력 및 처리
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            uf.union(a, b);
        }

        // 특정 두 사람이 같은 그룹에 속하는지 확인
        int x = sc.nextInt();
        int y = sc.nextInt();

        if (uf.connected(x, y)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        sc.close();
    }
}

/*
    입력:
    n = 5
    m = 3
    관계: (0, 1), (1, 2), (3, 4)
    x = 0, y = 2

    출력:
    YES

    입력:
    n = 5
    m = 3
    관계: (0, 1), (1, 2), (3, 4)
    x = 0, y = 4

    출력:
    NO
 */
