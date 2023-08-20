package programmers.test2304.test230412;

public class Memo {

}

/*
 
 1) concat?
텍스트 붙이는 메소드. stringbuffer와 append()를 이용하는 방법도 있음.

(1)
String result = text1.concat(text2); // result = text1 + text2

(2-1)
StringBuffer.append() - 문자열 추가하기

   StringBuffer buff = new StringBuffer();
    
    buff.append(2);
    buff.append(" + ");
    buff.append(1.3125);
    buff.append(" = ");
    buff.append(3.3125);
    
    System.out.println(buff);	// 2 + 1.3125 = 3.3125
//StringBuffer a = buff.append()를 쓰지 않고도 가능. 새로운 StringBuffer의 생성이 되지 않는다는 것은 아님.

(2-2)
StringBuffer.insert() - 문자열 삽입하기

  StringBuffer buff = new StringBuffer();
    
    buff.append("Welcome Blog");
    buff.insert(8, "my ");
 
    System.out.println(buff);	// Welcome my Blog

(2-3)
StrinBuffer.delete() - 문자열 삭제하기

StringBuffer buff = new StringBuffer();
    
    buff.append("Welcome my Blog");
    
    buff.deleteCharAt(0);
    System.out.println("buff = " + buff);	// buff = elcome my Blog
    
    buff.delete(0,4);
    System.out.println("buff = " + buff);	// buff = me my Blog
    
    buff.delete(0,buff.length());
    System.out.println("buff = " + buff);	// buff = 
 
 */
