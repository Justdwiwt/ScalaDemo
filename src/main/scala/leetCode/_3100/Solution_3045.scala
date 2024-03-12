package leetCode._3100

object Solution_3045 {
  def countPrefixSuffixPairs(words: Array[String]): Long = words
    .foldLeft(0L, Map.empty[String, Long].withDefaultValue(0L), Set.empty[Int]) {
      case ((res, mp, count), w) =>
        val z = zFunction(w)
        val newRes = (1 until w.length).foldLeft(res)((res, i) => {
          if (i + z(i) != w.length || !count.contains(z(i))) res
          else res + mp(w.slice(0, z(i)))
        })
        mp.get(w) match {
          case None => (newRes, mp.updated(w, 1), count + w.length)
          case Some(v) => (newRes + v, mp.updated(w, v + 1), count + w.length)
        }
    }
    ._1

  private def zFunction(s: String): Vector[Int] = {
    @scala.annotation.tailrec
    def dfs(i: Int, l: Int, r: Int, z: Vector[Int]): Vector[Int] =
      if (i == s.length) z
      else {
        val zi = (i, r) match {
          case (i, r) if i <= r => z(i - l).min(r - i + 1)
          case _ => 0
        }
        val j = findPrefix(i, zi + i)
        val (newL, newR) = if (j > r) (i, j - 1) else (l, r)
        dfs(i + 1, newL, newR, z :+ (j - i))
      }

    @scala.annotation.tailrec
    def findPrefix(i: Int, j: Int): Int =
      if (j == s.length || s(j) != s(j - i)) j else findPrefix(i, j + 1)

    dfs(i = 1, l = 0, r = 0, z = Vector(s.length))
  }
}
