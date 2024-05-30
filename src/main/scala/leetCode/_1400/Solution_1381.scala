package leetCode._1400

object Solution_1381 {
  class CustomStack(_maxSize: Int) {
    private var st = List.empty[Int]

    def push(x: Int): Unit =
      if (st.length < _maxSize) st = x :: st

    def pop(): Int = {
      if (st.isEmpty) return -1
      val x :: rest = st: @unchecked
      st = rest
      x
    }

    def increment(k: Int, inc: Int): Unit = st.length match {
      case n if n <= k => st = st.map(_ + inc)
      case _ =>
        val begin = st.take(st.length - k)
        val end = st.takeRight(k).map(_ + inc)
        st = begin ++ end
    }
  }
}
