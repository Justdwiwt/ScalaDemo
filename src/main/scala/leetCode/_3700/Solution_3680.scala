package leetCode._3700

object Solution_3680 {
  def generateSchedule(n: Int): Array[Array[Int]] = {
    if (n < 5) return Array.empty

    val middle = (2 until n - 1).flatMap(d => (0 until n).map(i => Array(i, (i + d) % n)))

    val edge = (0 until n).flatMap(i => Seq(Array(i, (i + 1) % n), Array((i - 1 + n) % n, (i - 2 + n) % n)))

    (middle ++ edge).toArray
  }
}
