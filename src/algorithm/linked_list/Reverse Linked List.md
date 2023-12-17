# Reverse Linked List

클래식한 문제로 시작해보자.

> singly linked list를 뒤집어라.

한 가지의 방법은 원래의 순서대로 node들을 순회한 뒤, node들을 하나씩 list의 head로 옮기는 것이다. 이해하기 어려울 수 있다. 알고리즘을 이해하기 위해 예제를 사용할 것이다.

## Algorithm Overview

예제를 보자.

<img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/14/screen-shot-2018-04-14-at-163143.png" width="470px">

까만 노드 23이 원래 head 노드임을 기억하라.

1. 첫 번째로, 까만 노드의 다음 노드인 노드 6을 list의 head로 움직인다.

<img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/14/screen-shot-2018-04-14-at-163336.png" width="590px">

2. 그리고 까만 노드의 다음 노드인 노드 15를 list의 head로 움직인다.

<img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/14/screen-shot-2018-04-14-at-163525.png" width="590px">

3. 까만 노드의 다음 노드가 null이 되었다. 따라서 우리는 멈추고 새로운 head 노드인 15를 반환한다.

<br>

## More

이 알고리즘에서 각각의 노드는 `정확히 한 번` 움직이게 될 것이다.

그러므로, 시간 복잡도는 linked list의 길아가 N일 때, `O(N)`이다. 상수의 추가공간만을 사용하므로 공간복잡도는 `O(1)`이다.

이 문제는 면접에서 마주칠 수도 있는 많은 linked list 문제들의 기초이다. 만약 이해가 잘 가지 않는다면 다음 article에서 구현 디테일에 대해 더 얘기할 것이다.

이 방법 말고도 많은 다른 방법들이 있다. 적어도 한 방법에 익숙해지고 구현할 줄 알아야 한다.