package leetCode

import scala.collection.mutable

object Solution_1408 {
  def stringMatching(words: Array[String]): List[String] = {
    var st = mutable.HashSet.empty[String]
    words./:(st)((_, n) => {
      words.foreach(b => if (n.r.findFirstIn(b).toList.nonEmpty && n != b) st += n)
      st
    })
    st.toList
  }
}
