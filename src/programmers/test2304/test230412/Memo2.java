package programmers.test2304.test230412;

public class Memo2 {

}

/*

Heap 메모리 영역?, 가비지 컬렉션?

1. JVM

JVM은 OS의 메모리 영역에 접근해서 Java의 메모리를 관리하는 가상의 프로그램
그런데 이 메모리를 막쓰면 되나? 안된다. 그냥 사용해서는 안되고 누군가 쓸때 할당을 해주고 다쓰고 나면 해제도 해줘야한다. 

C나 C++ 로 개발할 때는 사용자가 직접 관리를 해줬다.
C에서는 calloc, realloc, malloc 같은 걸로 메모리를 할당해서 쓰고나서 free로 해제를 직접해줘야 하고,
C++은 생성자와 소멸자를 이용해 메모리 관리를 해줘야 했다는 말이다.

그런데 이 메모리 관리를 자바에서는 GC(Garbage Collector) 가 해준다.
간단하게 이 GC의 기능을 먼저 말해주면 프로그램에서 동적으로 할당된 메모리 영역 중에서 사용하지 않는 영역을
이 GC가 탐지해서 해제해준다고 정도 알고 넘어가자.


2. Java 의 Stack 과 Heap
 
자바에서 메모리라 함은 Stack 영역과 Heap 영역으로 나뉘어 진다.

Stack의 경우에는 정적으로 할당된 메모리 영역이다.
Stack에서는 Primitive 타입 (boolean, char, short, int, long, float, double) 의 데이터가 값이랑 같이 할당이 되고,
또 Heap 영역에 생성된 Object 타입의 데이터의 참조 값이 할당 된다.

그리고 Stack 의 메모리는 Thread당 하나씩 할당 된다. 만약 새로운 스레드가 생성되면 해당 스레드에 대한 Stack이 새롭게 생성되고,
각 스레드 끼리는 Stack 영역을 접근할 수 가 없다.

Heap의 경우에는 동적으로 할당된 메모리 영역이다.

힙 영역에서는 모든 Object 타입의 데이터가 할당이 된다. (참고로 모든 객체는 Object 타입을 상속받는다.)
Heap 영역의 Object를 가리키는 참조변수가 Stack에 할당이 된다.
어플리케이션에서의 모든 메모리 중에서 Stack에 쌓이는 애들 빼고는 전부 이 Heap 쌓인다고 보면 편할듯 하다..

근데 보통 이 Heap 영역의 데이터들은 생명주기가 길다. 그 이유는 대부분 Object의 크기가 크고, 서로 다른 코드블럭에서도 공유가 되다 보니 그런것이다. 

그리고 Heap 은 Stack 처럼 Thread 마다 하나씩있는게 아니라 여러개의 Thread가 있어도 힙은 단하나의 영역만 존재한다. 헷갈리지 말자.

ex.

int age = 32;
stack -> age = 32

String name = "kang";
stack -> name
Heap -> String "kang"(참조하는 형태)

List<String> skills = new ArrayList<>();
stack -> skills
Heap -> List<>

skills.add("java");
skills.add("js");
skills.add("c++");
Heap -> List<0> = java
		List<1> = js
		List<2> = c++

참고 url : https://devkingdom.tistory.com/226

*/
