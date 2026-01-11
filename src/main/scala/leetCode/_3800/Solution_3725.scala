package leetCode._3800

object Solution_3725 {
  def countCoprime(mat: Array[Array[Int]]): Int = {
    val M = 1000000007

    @scala.annotation.tailrec
    def gcd(a: Int, b: Int): Int =
      if (b == 0) math.abs(a) else gcd(b, a % b)

    val finalMap = mat
      .foldLeft(Map(0 -> 1))((dp, row) => row
        .foldLeft(Map.empty[Int, Int])((next, x) => dp
          .foldLeft(next) { case (m, (g, cnt)) =>
            val ng = gcd(g, x)
            val nv = (m.getOrElse(ng, 0) + cnt) % M
            m.updated(ng, nv)
          }
        ))

    finalMap.getOrElse(1, 0)
  }
}
