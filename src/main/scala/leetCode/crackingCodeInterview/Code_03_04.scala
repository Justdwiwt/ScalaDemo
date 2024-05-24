package leetCode.crackingCodeInterview

import scala.collection.mutable

object Code_03_04 {

  class MyQueue() {
    private val numStack = mutable.Stack[Int]()
    private val helpStack = mutable.Stack[Int]()

    /** Push element x to the back of queue. */
    def push(x: Int): Unit =
      numStack.push(x)

    /** Removes the element from in front of queue and returns that element. */
    def pop(): Int = {
      peek()
      helpStack.pop()
    }

    /** Get the front element. */
    private def peek(): Int = {
      if (helpStack.isEmpty)
        while (numStack.nonEmpty)
          helpStack.push(numStack.pop())
      helpStack.top
    }

    /** Returns whether the queue is empty. */
    def empty(): Boolean =
      helpStack.isEmpty && numStack.isEmpty
  }

}
