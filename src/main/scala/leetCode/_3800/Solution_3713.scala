package leetCode._3800

object Solution_3713 {
  def longestBalanced(s: String): Int = {
    val n = s.length

    val pref: Vector[Vector[Int]] =
      s.foldLeft(Vector(Vector.fill(26)(0))) { (acc, c) =>
        val last = acc.last
        acc :+ last.updated(c - 'a', last(c - 'a') + 1)
      }

    def freq(l: Int, r: Int): Vector[Int] =
      pref(r).zip(pref(l)).map { case (a, b) => a - b }

    def isBalanced(f: Vector[Int]): Boolean = {
      val nz = f.filter(_ > 0)
      nz.nonEmpty && nz.distinct.size == 1
    }

    (n to 1 by -1)
      .find(k => (0 to n - k).exists(i => isBalanced(freq(i, i + k))))
      .getOrElse(0)
  }
}
