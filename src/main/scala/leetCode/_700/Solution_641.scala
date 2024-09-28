package leetCode._700

object Solution_641 {
  class MyCircularDeque(_k: Int) {
    private val deque = new Array[Int](_k)
    private var front = 0
    private var rear = 0
    private var size = 0

    def insertFront(value: Int): Boolean = {
      if (isFull) false
      else {
        front = (front - 1 + deque.length) % deque.length
        deque(front) = value
        size += 1
        true
      }
    }

    def insertLast(value: Int): Boolean =
      if (isFull) false
      else {
        deque(rear) = value
        rear = (rear + 1) % deque.length
        size += 1
        true
      }

    def deleteFront(): Boolean =
      if (isEmpty) false
      else {
        front = (front + 1) % deque.length
        size -= 1
        true
      }

    def deleteLast(): Boolean =
      if (isEmpty) false
      else {
        rear = (rear - 1 + deque.length) % deque.length
        size -= 1
        true
      }

    def getFront(): Int =
      if (isEmpty) -1
      else deque(front)

    def getRear(): Int =
      if (isEmpty) -1
      else deque((rear - 1 + deque.length) % deque.length)

    private def isEmpty: Boolean = size == 0

    private def isFull: Boolean = size == deque.length
  }
}
