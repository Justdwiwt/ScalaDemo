package leetCode

object Solution_806 {
  def numberOfLines(widths: Array[Int], S: String): Array[Int] = {
    var cnt = 1
    var res = 0
    S.foreach(i => {
      val t = widths(i - 'a')
      if (res + t > 100) cnt += 1
      res = if (res + t > 100) t else res + t
    })
    Array(cnt, res)
  }
}
