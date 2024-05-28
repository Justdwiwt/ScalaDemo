package leetCode._2300

object Solution_2223 {
  def sumScores(s: String): Long = {
    val n = s.length
    val z = Array.fill(n)(0)
    var res = 0L
    var left = 0
    var right = 0

    s.indices.drop(1).foreach(i => {
      if (i <= right && z(i - left) < right - i + 1)
        z(i) = z(i - left)
      else {
        z(i) = 0.max(right - i + 1)
        while (i + z(i) < n && s.charAt(z(i)) == s.charAt(i + z(i)))
          z(i) += 1
      }
      if (i + z(i) - 1 > right) {
        left = i
        right = i + z(i) - 1
      }
      res += z(i)
    })
    res += n
    res
  }
}
