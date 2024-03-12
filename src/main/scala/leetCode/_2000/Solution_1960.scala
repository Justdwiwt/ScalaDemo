package leetCode._2000

object Solution_1960 {
  def maxProduct(s: String): Long = {
    val n = s.length
    val len = Array.fill(n)(0)

    var j = -1
    var mx = -1
    s.indices.foreach(i => {
      if (i > mx) len(i) = 0
      else len(i) = len(2 * j - i).min(mx - i)
      while (i - len(i) - 1 >= 0 && i + len(i) + 1 < n && s(i - len(i) - 1) == s(i + len(i) + 1)) len(i) += 1
      if (i + len(i) > mx) {
        mx = i + len(i)
        j = i
      }
    })

    val left = Array.fill(n)(0)
    val right = Array.fill(n)(0)

    left(0) = 1

    var p = 0
    s.indices.drop(1).foreach(i => {
      while (p + len(p) < i) p += 1
      left(i) = left(i - 1).max(2 * (i - p) + 1)
    })
    right(n - 1) = 1

    var q = n - 1
    s.indices.dropRight(1).reverse.foreach(i => {
      while (q - len(q) > i) q -= 1
      right(i) = right(i + 1).max(2 * (q - i) + 1)
    })

    var res = 0L
    s.indices.dropRight(1).foreach(i => res = res.max(1L * left(i) * right(i + 1)))

    res
  }
}
