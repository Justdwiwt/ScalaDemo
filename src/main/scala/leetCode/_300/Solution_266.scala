package leetCode._300

import scala.collection.mutable

object Solution_266 {
  def canPermutePalindrome(s: String): Boolean = {
    var st = mutable.HashSet.empty[Char]
    s.indices.foreach(i => if (st.contains(s(i))) st -= s(i) else st += s(i))
    st.size <= 1
  }
}
