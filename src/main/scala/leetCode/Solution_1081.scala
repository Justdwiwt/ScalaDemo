package leetCode

object Solution_1081 {
  def smallestSubsequence(s: String): String = {
    val arr = Array.ofDim[Int](26)
    val st = scala.collection.mutable.Stack[Char]()
    val visited = scala.collection.mutable.Set[Char]()
    s.foreach(ch => arr(ch - 'a') += 1)

    def _insert(ch: Char) {
      st.push(ch)
      visited += ch
    }

    s.foreach(ch => {
      if (st.isEmpty) _insert(ch)
      else if (!st.contains(ch)) {
        (st.top, ch) match {
          case (t, e) if t < e => _insert(e)
          case (t, e) if t > e && arr(t - 'a') > 0 =>
            while (st.nonEmpty && st.top >= e && arr(st.top - 'a') > 0) visited -= st.pop
            _insert(e)
          case _ => _insert(ch)
        }
      }
      arr(ch - 'a') -= 1
    })
    st.mkString.reverse
  }
}
