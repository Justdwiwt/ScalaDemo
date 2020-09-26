package leetCode

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Solution_1096 {
  def braceExpansionII(expression: String): List[String] = {
    val st = new mutable.Stack[ArrayBuffer[String]]()
    var prev = new ArrayBuffer[String]()
    var cur = new ArrayBuffer[String]()
    expression.foreach({
      case '{' =>
        st.push(prev)
        st.push(cur)
        prev = new ArrayBuffer[String]()
        cur = new ArrayBuffer[String]()
      case '}' =>
        val tmp = prev ++ cur
        cur = st.pop
        if (cur.isEmpty) cur += ""
        cur = cur.flatMap(x => tmp.map(y => x + y))
        prev = st.pop
      case ',' =>
        prev ++= cur
        cur = new ArrayBuffer[String]()
      case c =>
        if (cur.isEmpty) cur += ""
        cur = cur.map(x => x + c)
    })
    (prev ++ cur).toSet.toList.sorted
  }
}
