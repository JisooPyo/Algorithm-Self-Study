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
