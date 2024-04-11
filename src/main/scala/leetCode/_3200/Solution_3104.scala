package leetCode._3200

object Solution_3104 {
  def maxSubstringLength(s: String): Int = {
    var map = Map[Char, (Int, Int, Int)]()
    var res = -1
    s.zipWithIndex.foreach { case (v, i) =>
      if (!map.contains(v)) map += (v -> (i, i, 1))
      else {
        val (start, _, count) = map(v)
        map += (v -> (start, i, count + 1))
      }
    }
    val sorted = map.keys.toList.sortBy(map)
    val n = map.size
    (0 until n).foreach(i => {
      val (a, _, _) = map(sorted(i))
      var (b, c) = (0, 0)
      (i until n - (if (i == 0) 1 else 0)).foreach(j => {
        val (_, nb, nc) = map(sorted(j))
        b = b.max(nb)
        c += nc
        if (b - a + 1 == c) res = res.max(c)
      })
    })
    res
  }
}
