package leetCode._2500

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Solution_2434 {
  def robotWithString(input: String): String = {
    val m = mutable.HashMap.empty[Char, ArrayBuffer[Int]].withDefault(_ => ArrayBuffer.empty)
    input.indices.foreach(idx => {
      val ch = input.charAt(idx)
      if (!m.contains(ch)) m += ch -> ArrayBuffer.empty[Int]
      m(ch) += idx
    })
    val st = mutable.Stack[Char]()
    var curIdx = 0
    val sb = new mutable.StringBuilder()
    ('a' to 'z').foreach(c => {
      while (st.nonEmpty && st.top <= c) sb.append(st.pop())
      m(c).foreach(i => if (curIdx <= i) {
        (curIdx until i).foreach(j => st.push(input.charAt(j)))
        sb.append(c)
        curIdx = i + 1
      })
    })
    while (st.nonEmpty) sb.append(st.pop())
    sb.toString()
  }
}
