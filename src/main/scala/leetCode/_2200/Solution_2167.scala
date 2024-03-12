package leetCode._2200

object Solution_2167 {
  def minimumTime(s: String): Int = {
    var t = 0
    var res = s.length
    s.indices.foreach(i => {
      if (s(i) == '1') t = (t + 2).min(i + 1)
      res = res.min(t + s.length - 1 - i)
    })
    res
  }
}
