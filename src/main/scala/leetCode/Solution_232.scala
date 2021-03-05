package leetCode

object Solution_232 {

  class MyQueue() {

    /** Initialize your data structure here. */
    private val normal = collection.mutable.Stack[Int]()
    private val rev = collection.mutable.Stack[Int]()


    /** Push element x to the back of queue. */
    def push(x: Int) {
      normal.push(x)
    }

    /** Removes the element from in front of queue and returns that element. */
    def pop(): Int = {
      var elem = normal.pop()
      rev.clear()
      rev.push(elem)
      while (normal.nonEmpty)
        rev.push(normal.pop())
      if (rev.nonEmpty)
        elem = rev.pop()
      while (rev.nonEmpty)
        normal.push(rev.pop())
      elem
    }

    /** Get the front element. */
    def peek(): Int = {
      var elem = normal.pop()
      rev.clear()
      rev.push(elem)
      while (normal.nonEmpty) {
        elem = normal.pop()
        rev.push(elem)
      }
      while (rev.nonEmpty)
        normal.push(rev.pop())
      elem
    }

    /** Returns whether the queue is empty. */
    def empty(): Boolean =
      normal.isEmpty

  }

}
