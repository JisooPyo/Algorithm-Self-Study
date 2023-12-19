# Singly Linked List

Introduction에서 언급했다시피, linked list는 모든 각각의 요소들이 참조 필드로써 연결되어 있는 선형적인 자료 구조이다. 자주 쓰이는 linkded list의 유형은 두 가지가
있다. `singly-linked list`와 `doubly-linked list`

이 챕터에서는 singly-linked list로 시작할것이다. 그리고, 다음을 도울 것이다.

* singly-linked list의 구조를 이해
* singly-linked list의 순회, 삽입, 삭제를 수행
* singly-linked list의 다른 연산들의 시간 복잡도를 분석

## Introduction - Singly Linked List

singly-linked list의 각 노드는 value뿐 아니라 다음 노드에 연결되는 참조 필드도 포함하고 있다. 이런 식으로, singly-linked list는 모든 노드들을 연속으로 조직한다.

다음은 singly-linked list의 예시이다.

<img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/12/screen-shot-2018-04-12-at-152754.png" width="410px">

파란 화살표는 singly linked list에 있는 노드들이 어떻게 같이 결합되어 있는지를 보여준다.

### Node Structure

다음은 singly-linked list의 노드의 전형적인 정의이다.

```java
// Definition for singly-linked list.
public class SinglyListNode {
    int val;
    SinglyListNode next;

    SinglyListNode(int x) {
        val = x;
    }
}
```

대부분의 케이스들에서 전체 리스트를 표현하기 위해 head node(첫 번째 노드)를 사용한다.

### Operations

배열과 다르게 singly-linked list의 랜덤 요소에 상수 시간으로 접근할 수 없다. 만약 i번째 요소를 얻고 싶다면, head node부터 하나씩 탐색해야만 한다. index로써 요소를 방문하는 것은
linked list의 길이가 N일 때, 평균적으로 O(N)의 시간이 걸린다.

예를 들어, 위에 있는 그림의 예시의 경우, head는 node 23이다. 3번째 node를 방문하는 한 가지 방법은 2번째 노드(노드 6)을 얻기 위해 head 노드의 next 필드를 이용하는 것이다. 그러면
node 6의 next 필드를 이용하여, 3번째 노드를 방문할 수 있다.

너는 index로 데이터에 접근하는 방식이 비효율적임에도 불구하고 왜 linked list가 유용한지 궁금할 것이다. 다음 두 article에서 삽입과 삭제에 대해 얘기하면 linked list의 이익에 대해서
깨달을 수 있을 것이다.

그 이후, singly linked list를 디자인하는 연습문제를 제공할 것이다.

<br>

## Add Operation - Singly Linked List

만약 주어진 `prev`노드 이후에 새 값을 추가하고 싶다면 우리는 다음을 이행해야 한다.

1. 주어진 값으로 새 노드 `cur`을 초기화한다.

<img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/26/screen-shot-2018-04-25-at-163224.png" width="460px">

2. prev노드의 다음 노드인 `next` 노드를 `cur`의 다음 필드로 연결한다.

<img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/26/screen-shot-2018-04-25-at-163234.png" width="460px">

3. `prev`노드의 다음 노드를 `cur`로 연결한다.

<img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/26/screen-shot-2018-04-25-at-163243.png" width="460px">

배열과 다르게 삽입되는 요소 이후 모든 요소들을 이동시키지 않아도 된다. 그러므로 만약 `prev` 노드에 대한 참조를 알고 있다면 `O(1)`의 시간 복잡도로 linked list에 새 노드를 삽입할 수 있고,
이것은 매우 효율적이다.

### An Example

<img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/12/screen-shot-2018-04-12-at-152754.png" width="420px">

두 번째 노드 6 다음에 새로운 값 9를 삽입해보자.

먼저 값이 9인 새로운 노드를 초기화한 후, 노드 9와 노드 15를 연결시킨다. 마지막으로 노드 6과 노드 9를 연결시킨다.

삽입 이후, linkded list는 다음과 같을 것이다.

<img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/12/screen-shot-2018-04-12-at-154238.png" width="400px">

### Add a Node at the Beginning

알다시피, 전체 list를 표현하기 위해 우리는 헤드 노드인 `head`를 사용하여야 한다.

그래서 list의 시작점에 새로운 노드를 추가할 때 `head`를 업데이트하는 것은 중요하다.

1. 새 노드 cur을 초기화한다.
2. 새 노드와 원래 헤드 노드인 `head`를 연결한다.
3. cur 노드를 `head`로 할당한다.

예를 들어, list의 시작점에 노드 9를 추가해보자.

1. 새 노드 9를 초기화하고 노드 9와 현재 헤드 노드 23을 연결한다.

<img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/19/screen-shot-2018-04-19-at-125118.png" width="490px">

2. 노드 9를 새로운 헤드로 할당한다.

<img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/19/screen-shot-2018-04-19-at-125350.png" width="490px">

<br>

## Delete Operation - Singly Linked List

만약 singly-linked list에서 기존 노드 `cur`을 삭제하고 싶다면, 다음 두 가지 스텝으로 가능하다.

1. cur의 이전 노드인 `prev`와 다음 노드인 `next`를 찾는다.

<img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/27/screen-shot-2018-04-26-at-203558.png" width="520px">

2. `prev`와 cur의 다음 노드인 `next`노드를 연결한다.

<img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/26/screen-shot-2018-04-26-at-203640.png" width="520px">

첫 번째 스텝을 보면, `prev`와 `next`를 찾아야 한다. `next`는 `cur`의 참조 필드를 이용하면 쉽게 찾을 수 있다. 그러나, `prev`를 찾기 위해서는 head 노드에서부터 linked
list를 탐색해야 하고, 이는 평균적으로 linked list의 길이가 N일 때, O(N)의 시간복잡도를 가진다. 그래서 노드를 삭제하는 시간 복잡도는 O(N)이다.

공간복잡도는 포인터를 저장할 상수 공간만이 필요하기 때문에 O(1)이다.

### An Example

<img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/12/screen-shot-2018-04-12-at-152754.png" width="410px">

위의 singly linked list에서 node 6을 삭제해보자.

1. 노드 23인 이전 노드 `prev`를 찾을 때까지 head에서부터 linked list를 순회해야 한다.
2. `prev`(노드 23)와 `next`(노드 15)를 연결시킨다.

<img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/12/screen-shot-2018-04-12-at-154821.png" width="410px">

노드 6은 이제 singly linked list에 존재하지 않는다.

### Delete the First Node

만약 첫 번째 노드를 삭제하고 싶다면 전략은 조금 달라질 것이다.

전에 언급했다 시피, linked list를 표현하기 위해 head 노드 `head`를 사용한다. 밑의 예시에서 head는 까만색 노드 23이다.

<img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/19/screen-shot-2018-04-19-at-130024.png" width="380px">

만약 첫 번째 노드를 삭제하고 싶다면, 단순하게 `다음 노드를 헤드로 할당`하면 된다. 다시 말해서, 삭제 이후 head는 노드 6이 된다.

<img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/19/screen-shot-2018-04-19-at-130031.png" width="380px">

linked list는 head에서부터 시작한다. 따라서 노드 23은 더 이상 linked list에 존재하지 않는다.