package leetCode._1200

object Solution_1180 {
  def countLetters(s: String): Int = {
    var cnt = 1
    var res = 0
    s.indices.drop(1).foreach(i => {
      if (s(i) == s(i - 1)) cnt += 1
      else {
        res += cnt * (cnt + 1) / 2
        cnt = 1
      }
    })
    res += cnt * (cnt + 1) / 2
    res
  }
}
