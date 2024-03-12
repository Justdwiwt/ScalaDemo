package leetCode.crackingCodeInterview

import scala.collection.mutable

object Code_03_02 {

  class MinStack() {

    private val m = new mutable.Stack[Int]
    private val s = new mutable.Stack[Int]

    def push(x: Int): Unit = {
      s.push(x)
      if (m.isEmpty || x <= m.top) m.push(x)
    }

    def pop(): Unit = {
      if (s.nonEmpty) {
        if (s.top == m.top) m.pop()
        s.pop()
      }
    }

    def top(): Int = s.top

    def getMin(): Int = m.top

  }

}
