package leetCode._3600

import scala.collection.mutable

object Solution_3579 {
  def minOperations(word1: String, word2: String): Int = {
    val n = word1.length
    val revOp = Array.ofDim[Int](n, n)

    def update(cnt: mutable.Map[(Char, Char), Int], x: Char, y: Char): Int = {
      if (x == y) return 0
      val a = (y, x)
      if (cnt.getOrElse(a, 0) > 0) {
        cnt(a) -= 1
        if (cnt(a) == 0) cnt -= a
        0
      } else {
        val b = (x, y)
        cnt(b) = cnt.getOrElse(b, 0) + 1
        1
      }
    }

    (0 until 2 * n - 1).foreach(i => {
      val cnt = mutable.Map.empty[(Char, Char), Int]
      var op = 1
      var l = i / 2
      var r = (i + 1) / 2
      while (l >= 0 && r < n) {
        op += update(cnt, word1(l), word2(r))
        if (l != r) op += update(cnt, word1(r), word2(l))
        revOp(l)(r) = op
        l -= 1
        r += 1
      }
    })

    val f = Array.fill(n + 1)(Int.MaxValue)
    f(0) = 0

    word1.indices.foreach(i => {
      val cnt = mutable.Map.empty[(Char, Char), Int]
      var op = 0
      (i to 0 by -1).foreach(j => {
        op += update(cnt, word1(j), word2(j))
        val cost = op.min(revOp(j)(i))
        f(i + 1) = f(i + 1).min(f(j) + cost)
      })
    })

    f(n)
  }
}
