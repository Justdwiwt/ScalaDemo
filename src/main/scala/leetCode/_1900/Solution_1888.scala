package leetCode._1900

object Solution_1888 {
  def minFlips(s: String): Int = {
    val n = s.length
    val target = "01"

    var cnt = 0
    s.indices.foreach(i => cnt += (if (s(i) != target(i % 2)) 1 else 0))

    var res = cnt.min(n - cnt)
    s.indices.foreach(i => {
      cnt -= (if (s(i) != target(i % 2)) 1 else 0)
      cnt += (if (s(i) != target((i + n) % 2)) 1 else 0)
      res = res.min(cnt.min(n - cnt))
    })

    res
  }
}
