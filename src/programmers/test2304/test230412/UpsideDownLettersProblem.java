package programmers.test2304.test230412;

public class UpsideDownLettersProblem {

	public static void main(String[] args) {
		
		UpsideDownLettersProblem turn = new UpsideDownLettersProblem();
		
		System.out.println(turn.solution("jaron"));
		System.out.println(turn.solution("bread"));

	}
	
    public String solution(String my_string) {
    	
    	StringBuilder sb = new StringBuilder(my_string);
    	String answer = sb.reverse().toString();
        
        return answer;
    }

}

/*

public class String_Reverse_Practice {
    public static void main(String[] args) {
        String str = "abcde";

        // reverse
        StringBuffer sb = new StringBuffer(str);
        String reversedStr = sb.reverse().toString();

        System.out.println(reversedStr); // edcba
    }
}

------------------------------------------------------------
public class String_Reverse_Practice {
    public static void main(String[] args) {
        String str = "abcde";

        char[] arr = str.toCharArray(); 			// String -> char[]
        char[] reversedArr = new char[arr.length];
        for(int i=0; i<arr.length; i++){
            reversedArr[arr.length-1-i] = arr[i];
        }

        String reversedStr = new String(reversedArr);
        System.out.println(reversedStr); 			// edcba
    }
}
------------------------------------------------------------
public class String_Reverse_Practice {
    public static void main(String[] args) {
        String str = "abcde";

        char[] arr = str.toCharArray(); // String -> char[]
        List<Character> list = new ArrayList<>();
        for(char each : arr){ // char[] -> List
            list.add(each);
        }

        // reverse
        Collections.reverse(list);

        ListIterator li = list.listIterator();
        while(li.hasNext()){
            System.out.print(li.next()); // edcba
        }
    }
}

*/