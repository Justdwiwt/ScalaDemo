package leetCode._3800

object Solution_3720 {
  def lexGreaterPermutation(s: String, target: String): String = {
    val A = 26

    def inc(a: Vector[Int], i: Int, v: Int) =
      a.updated(i, a(i) + v)

    val left0 =
      s.foldLeft(Vector.fill(A)(0))((a, c) => inc(a, c - 'a', 1))

    val left1 =
      target.foldLeft(left0)((a, c) => inc(a, c - 'a', -1))

    val (neg0, mask0) =
      (0 until A).foldLeft(0 -> 0) { case ((neg, mask), i) =>
        if (left1(i) < 0) (neg + 1, mask)
        else if (left1(i) > 0) (neg, mask | (1 << i))
        else (neg, mask)
      }

    @scala.annotation.tailrec
    def dfs(i: Int, left: Vector[Int], neg: Int, mask: Int): Option[String] =
      if (i < 0) None
      else {
        val idx = target(i) - 'a'
        val left2 = inc(left, idx, 1)

        val (neg2, mask2) =
          if (left2(idx) == 0) (neg - 1, mask)
          else if (left2(idx) == 1) (neg, mask | (1 << idx))
          else (neg, mask)

        if (neg2 > 0 || (mask2 >> (idx + 1)) == 0)
          dfs(i - 1, left2, neg2, mask2)
        else {
          val bigger = mask2 & ~((1 << (idx + 1)) - 1)
          val j = Integer.numberOfTrailingZeros(bigger)

          val left3 = inc(left2, j, -1)

          val prefix = target.substring(0, i) + (j + 'a').toChar
          val suffix =
            (0 until A).flatMap(k => List.fill(left3(k))((k + 'a').toChar)).mkString

          Some(prefix + suffix)
        }
      }

    dfs(target.length - 1, left1, neg0, mask0).getOrElse("")
  }
}
