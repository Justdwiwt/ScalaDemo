package leetCode._200

import scala.collection.mutable

object Solution_155 {

  class MinStack() {

    private val s1 = new mutable.Stack[Int]()
    private val s2 = new mutable.Stack[Int]()

    def push(x: Int) {
      s1.push(x)
      if (s2.isEmpty || x <= s2.top) s2.push(x)
    }

    def pop() {
      if (s1.top == s2.top) s2.pop()
      s1.pop()
    }

    def top(): Int = s1.top

    def getMin(): Int = s2.top

  }

}
