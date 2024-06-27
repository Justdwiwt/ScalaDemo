package leetCode._3200

object Solution_3199 {
  implicit class RichInt(val x: Int) extends AnyVal {
    def bitCount: Int = Integer.bitCount(x)
  }

  def tripletCount(a: Array[Int], b: Array[Int], c: Array[Int]): Int = a
    .flatMap(i => b.flatMap(j => c.map(k => (i, j, k))))
    .count { case (i, j, k) => (i ^ j ^ k).bitCount % 2 == 0 }
}
