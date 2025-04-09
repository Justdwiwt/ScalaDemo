package leetCode._3600

object Solution_3504 {
  def longestPalindrome(s: String, t: String): Int = {
    def calc(s: String, t: String): Int = {
      val n = s.length
      val m = t.length

      val vec: Vector[Vector[Int]] =
        (0 to n).foldLeft(Vector(Vector.fill(m + 1)(0)))((rows, i) => {
          if (i < n) {
            val prev = rows.last
            val newRow = (0 until m).foldLeft(Vector.fill(m + 1)(0))((row, j) => {
              val v = if (s(i) == t(j)) prev(j + 1) + 1 else 0
              row.updated(j, v)
            })
            rows :+ newRow
          } else rows
        })

      val mx: Vector[Int] = vec.map(_.max)
      val initAns = mx.max * 2

      def expand(l0: Int, r0: Int): (Int, Int) = {
        @scala.annotation.tailrec
        def loop(l: Int, r: Int): (Int, Int) =
          if (l >= 0 && r < n && s(l) == s(r)) loop(l - 1, r + 1)
          else (l, r)

        loop(l0, r0)
      }

      val centerAns = (0 until (2 * n - 1)).foldLeft(initAns)((acc, i) => {
        val (l0, r0) = (i / 2, (i + 1) / 2)
        val (l, r) = expand(l0, r0)
        if (l + 1 <= r - 1)
          acc.max((r - l - 1) + mx(l + 1) * 2)
        else acc
      })
      centerAns
    }

    calc(s, t).max(calc(t.reverse, s.reverse))
  }
}
