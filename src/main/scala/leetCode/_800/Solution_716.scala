package leetCode._800

import scala.collection.mutable

object Solution_716 {

  class MaxStack {
    private val stack = mutable.Stack[Int]()
    private val max = mutable.Stack[Int]()
    private val buf = mutable.Stack[Int]()

    def push(x: Int): Unit = {
      if (max.isEmpty || x >= max.top) max.push(x)
      stack.push(x)
    }

    def pop(): Int = {
      if (stack.top == max.top) max.pop()
      stack.pop()
    }

    def top(): Int =
      stack.top

    def peekMax(): Int =
      max.top

    def popMax(): Int = {
      while (stack.top != max.top) buf.push(stack.pop())

      val ret = pop()
      while (buf.nonEmpty) push(buf.pop())

      ret
    }
  }

}
