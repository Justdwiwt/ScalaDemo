package leetCode

object Solution_316 {
  def removeDuplicateLetters(s: String): String = {
    if (s.length == 1) return s
    val arr = Array.fill(26)(26)
    s.zipWithIndex.foreach({ case (c, i) => arr(c - 'a') = i })
    val seen = Array.fill(26)(false)
    var st = List.empty[Char]
    s.zipWithIndex.foreach({ case (c, i) =>
      if (!seen(c - 'a')) {
        while (st.nonEmpty && st.head > c && arr(st.head - 'a') > i) {
          seen(st.head - 'a') = false
          st = st.tail
        }
        seen(c - 'a') = true
        st = c +: st
      }
    })
    st.reverse.mkString
  }
}
