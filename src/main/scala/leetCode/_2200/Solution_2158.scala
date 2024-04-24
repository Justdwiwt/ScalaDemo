package leetCode._2200

object Solution_2158 {
  def amountPainted(paint: Array[Array[Int]]): Array[Int] = {
    val max = paint.map(_(1)).max
    val paints = Array.fill(max + 1)(1)

    def f(paints: Array[Int], start: Int, end: Int): Int = {
      val painted = (start until end).count(i =>
        if (paints(i) == 1) {
          paints(i) = 0
          true
        } else false
      )
      painted
    }

    paint.map { case Array(start, end) => f(paints, start, end) }
  }
}
