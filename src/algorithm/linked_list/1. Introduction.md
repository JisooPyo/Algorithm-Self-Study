## Introduction

이 카드에서는 또 다른 자료 구조 `Linked List`에 대해서 소개할 것이다.

배열과 비슷하게, Linked List 또한 `선형적인` 자료 구조이다. 여기에 예시가 있다.

<img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/12/screen-shot-2018-04-12-at-152754.png" width="450px">

위의 그림에서 볼 수 있듯이, linked list 내의 각 요소는 사실상 별도의 객체이며, 모든 객체는 각 요소의 `참조 필드에 의해 서로 연결`되어 있다.

linked list는 두가지의 유형이 있다. singly linked list와 doubly linked list이다. 위의 예시는 singly linked list이고 아래의 예시는 doubly linked
list이다.

<img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/17/screen-shot-2018-04-17-at-161130.png" width="600px">

이후의 챕터에서 더 자세하게 설명할 것이다. 이 카드가 끝난 후 당신은

* singly linked list와 doubly linked list의 구조에 대해 이해 할 수 있다.
* singly, doubly linked list의 순회, 삽입, 삭제를 구현할 수 있다.
* singly, doubly linked list의 다른 연산들의 복잡성에 대해 분석할 수 있다.
* liked list에서 two-pointer technique(fast-pointer-slow-pointer technique)을 사용할 수 있다.
* linked list를 reverse하는 것과 같은 클래식한 문제를 풀 수 있다.
* 디자인한 알고리즘에 대해 복잡성을 분석할 수 있다.
* 디자인과 디버깅에 대한 경험을 쌓을 수 있다.