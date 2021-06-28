package leetCode

object Solution_1910 {
  def removeOccurrences(s: String, part: String): String = {
    var st = List.empty[Char]
    s.foreach(c => {
      while (st.size >= part.length && st.take(part.length).reverse.mkString("") == part) {
        st = st.drop(part.length)
      }
      st = c +: st
    })
    while (st.size >= part.length && st.take(part.length).reverse.mkString("") == part) {
      st = st.drop(part.length)
    }
    st.reverse.mkString
  }
}
