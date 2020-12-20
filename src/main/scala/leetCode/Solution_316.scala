package leetCode

import scala.collection.mutable
import scala.util.control.Breaks._

object Solution_316 {
  def removeDuplicateLetters(s: String): String = {
    val st = mutable.Stack[Char]()
    val m = mutable.Map[Char, Int]()
    s.indices.foreach(i => m(s(i)) = i)
    s.indices.foreach(i => breakable {
      val t = s(i)
      if (st.contains(t)) break()
      while (st.nonEmpty && st.top > t && m(st.top) > i) {
        val top = st.pop
      }
      st.push(t)
    })
    st.mkString.reverse
  }
}
