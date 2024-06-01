package leetCode._2600

object Solution_2573 {
  def findTheString(lcp: Array[Array[Int]]): String = {
    val n = lcp.length
    val s = Array.fill[Char](n)('\u0000')

    var i = 0
    var flag = false

    ('a' to 'z')
      .withFilter(_ => !flag)
      .foreach(c => {
        while (i < n && s(i) > 0) i += 1
        if (i == n) flag = true
        else {
          (i until n)
            .withFilter(lcp(i)(_) > 0)
            .foreach(s(_) = c)
        }
      })

    if (!flag && s.contains('\u0000')) return ""

    var isValid = true
    ((n - 1) to 0 by -1)
      .withFilter(_ => isValid)
      .foreach(i => ((n - 1) to 0 by -1)
        .withFilter(_ => isValid)
        .foreach(j => {
          val actualLCP = if (s(i) != s(j)) 0
          else if (i == n - 1 || j == n - 1) 1
          else lcp(i + 1)(j + 1) + 1
          if (lcp(i)(j) != actualLCP) isValid = false
        }))
    if (isValid) new String(s) else ""
  }
}
