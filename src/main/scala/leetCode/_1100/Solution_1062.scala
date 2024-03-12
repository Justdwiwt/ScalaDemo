package leetCode._1100

object Solution_1062 {
  def longestRepeatingSubstring(s: String): Int = {
    var res = 0
    var t = 0
    s.indices.drop(1).foreach(i => {
      t = 0
      (i until s.length).foreach(j => {
        if (s(j) == s(j - i)) t += 1
        else {
          res = res.max(t)
          t = 0
        }
        res = res.max(t)
      })
    })
    res
  }
}
