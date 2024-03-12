package leetCode._500

import scala.collection.mutable

object Solution_439 {
  def parseTernary(expression: String): String = {
    var st = new mutable.Stack[Char]
    val ch = expression.toCharArray
    (ch.length - 1 to 2 by -2).foreach(i => {
      if (ch(i - 1) == ':') st.push(ch(i))
      else {
        ch(i - 2) = if (ch(i - 2) == 'T') ch(i) else st.top
        st.pop()
      }
    })
    ch.head.toString
  }
}
