# Two Pointer Technique

다른 카드(Array 자료 구조)에서 Two-Pointer Technique에 대해 소개했었다.

간단하게 이 테크닉에 대해 복습해보자. two-pointer 테크닉을 사용하는 두 가지의 시나리오를 언급했었다.

1. 두 개의 포인터는 `다른 위치에서 시작한다`: 하나는 시작점에서, 하나는 끝 점에서 시작한다.
2. 두 개의 포인터는 `다른 속도로 움직여진다`: 하나는 빠르게, 다른 하나는 더 느리게.

singly linked list에서는 한 쪽 방향으로만 순회할 수 있기 때문에 첫 번째 시나리오는 적용할 수 없다. 그러나, 두 번째 시나리오(slow-pointer and fast-pointer
technique로 불리는)는 아주 유용하다.

이 챕터에서는 linked list에서 `slow-pointer and fast-pointer` 문제에 대해 집중할 것이며 이 문제를 푸는 방법을 보여줄 것이다.

<br>

## Two-Pointer in Linked List

클래식한 문제로 시작해보자.

> 주어진 linked list에서 사이클이 있는지 없는지 알아내어라.

너는 아마 `hash table`을 사용하는 방법을 떠올릴지 모른다. 하지만 `two-pointer 테크닉`을 이용하는 더 효율적인 방법이 있다. 이후 내용을 읽기 전에 스스로 생각해보아라.

다른 속도의 두 runner가 있다고 상상해보아라. 만약 그들이 직선 경로에서 달리고 있다면, 빠른 사람이 먼저 목적지에 도착할 것이다. 그러나, 만약 그들이 원형 트랙에서 달리고 있다면, 만약 그들이 계속 달린다면
빠른 사람이 느린 사람을 따라 잡을 것이다.

이것이 정확히 우리가 사용할 방법이다.

1. `만약 cycle이 없다면, 빠른 포인터는 linked list의 끝에서 멈출 것이다.`
2. `만약 cycle이 있다면, 빠른 포인터는 느린 포인터와 결국 만나게 될 것이다.`

남은 문제는 다음과 같다.

> 두 포인터의 적절한 스피드는 어떻게 설정해야 하는가?

가장 안전한 선택은 느린 포인터가 한 번에 한 스텝 움직일 때 빠른 포인터는 한 번에 두 스텝을 움직이는 것이다. 각각의 순회에서 빠른 포인터는 하나의 여분의 스텝을 더 움직인다. 만약 cycle의 길이가 M이라고
하면, M번의 반복 이후, 빠른 포인터는 무조건 한 사이클 이상을 움직이며, 느린 포인터를 따라 잡을 것이다.

> 다른 선택지는 없는가? 그 선택지는 적용시킬 수 있는가? 그 선택지는 더 효율적인가?

<br>

## Summary - Two-Pointer in Linked List

여기에 linked list에서 two-pointer 문제를 푸는 템플릿이 있다.

```java
// Initialize slow & fast pointers
ListNode slow=head;
        ListNode fast=head;
/**
 * Change this condition to fit specific problem.
 * Attention: remember to avoid null-pointer error
 **/
        while(slow!=null&&fast!=null&&fast.next!=null){
        slow=slow.next;           // move slow pointer one step each time
        fast=fast.next.next;      // move fast pointer two steps each time
        if(slow==fast){         // change this condition to fit specific problem
        return true;
        }
        }
        return false;   // change return value to fit specific problem
```

### Tips

배열에서 배웠던 것과 비슷하지만 더 까다롭고 오류가 나기 쉽다. 주의해야 할 몇 가지가 있다.

1. next 필드를 호출하기 전에 node가 null인지 검사하라.

null 노드의 next 노드를 얻는 것은 null-pointer 에러를 야기시킨다. 예를 들어, `fast = fast.next.next`를 실행하기 전에 fast와 fast.next가 null이 아님을 검사할
필요가 있다.

2. loop의 end 상태를 신중하게 정의하라.

몇 가지 예제를 실행시켜 end 상태를 확실히 하면 endless loop를 야기시키지 않을 것이다. 그리고 end 상태를 정의할 때 첫번째 tip을 고려해야 한다.

### 복잡도 분석

공간 복잡도를 분석하는 것은 쉽다. 만약 다른 추가의 공간 없이 pointer만을 사용한다면 공간 복잡도는 O(1)이 될 것이다. 하지만 시간 복잡도를 분석하는 것은 더 어렵다. 답을 얻기
위해 `loop를 몇 번 실행 시킬 것인지` 분석할 필요가 있다.

이전에 cycle을 찾는 문제에서, 한 번에 faster pointer는 2 스텝을 움직이고, slower pointer는 1 스텝을 움직인다고 가정하자.

1. 만약 cycle이 없다면, faster pointer는 linked list의 길이가 N일 때, linked list의 끝에 도달하기 위해서 `N/2의 시간`이 걸릴 것이다.
2. cycle이 있다면, faster pointer는 slower pointer를 따라 잡기 위해 `M번의 시간`이 필요하다. 여기서 M은 list의 cycle의 길이이다.

M이 N보다 작거나 같음은 명백하다. 때문에 loop를 최대 N번 실행시키게 된다. 그리고 각각의 loop에서 상수의 시간이 걸린다. 그러므로 이 알고리즘의 시간 복잡도는 총 `O(N)`이 된다.

분석 스킬을 향상시키기 위해 다른 문제들을 스스로 분석해보아라. 다양한 조건을 고려하는 것을 기억하라. 모든 상태에 대해 분석하기 어렵다면, worst case를 고려하라.