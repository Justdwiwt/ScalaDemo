package leetCode

import scala.collection.mutable

object Solution_946 {
  def validateStackSequences(pushed: Array[Int], popped: Array[Int]): Boolean = {
    val st = new mutable.Stack[Int]()
    var j = 0
    pushed.foreach(x => {
      st.push(x)
      while (st.nonEmpty && j < pushed.length && st.head == popped(j)) {
        st.pop()
        j += 1
      }
    })
    j == pushed.length
  }
}
