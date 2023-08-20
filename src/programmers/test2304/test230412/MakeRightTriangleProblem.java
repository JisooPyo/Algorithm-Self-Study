package programmers.test2304.test230412;

import java.util.Scanner;

public class MakeRightTriangleProblem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for(int i = 1; i<=n ; i++) {
        	for(int j=1;j<=i; j++) {
        		System.out.print("*");
        	}
        	System.out.println();        	
        }
    }
}

// System.out.println(); -> ()안의 내용을 print하고 한 줄 내린다.        	
// System.out.print(); -> ()안의 내용을 print하고 한 줄 내리지 않고 끝낸다.        	

