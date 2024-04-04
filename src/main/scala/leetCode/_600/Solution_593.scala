package leetCode._600

object Solution_593 {
  def validSquare(p1: Array[Int], p2: Array[Int], p3: Array[Int], p4: Array[Int]): Boolean = {
    def distance(x: Array[Int], y: Array[Int]): Int =
      (x.head - y.head) * (x.head - y.head) + (x(1) - y(1)) * (x(1) - y(1))

    val st = Seq(p1, p2, p3, p4).combinations(2).map { case Seq(x, y) => distance(x, y) }.toSet

    !st.contains(0) && st.size == 2
  }
}
