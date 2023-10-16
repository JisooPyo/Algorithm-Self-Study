package leetcode.al10;

public class ArrayAndString8 {
	public static void main(String[] args) {
		ArrayAndString8 aas8 = new ArrayAndString8();

		System.out.println(aas8.strStr("sadbutsad", "sad"));
		System.out.println(aas8.strStr("leetcode", "leeto"));
	}

	public int strStr(String haystack, String needle) {
		return haystack.indexOf(needle);
	}
}
