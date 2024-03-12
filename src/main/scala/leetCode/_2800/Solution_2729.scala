package leetCode._2800

object Solution_2729 {
  def isFascinating(n: Int): Boolean = {
    def h(i: Int): Seq[Int] =
      if (i < 10) Seq(i)
      else (i % 10) +: h(i / 10)

    val l = h(n) ++ h(n * 2) ++ h(n * 3)
    l.sorted == (1 to 9)
  }
}
