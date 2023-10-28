package leetCode

object Solution_2904 {
  def shortestBeautifulSubstring(s: String, k: Int): String = {
    if (s.replaceAll("0", "").length < k) return ""
    (k to s.length).foreach(size => {
      var res = ""
      (size to s.length).foreach(i => {
        val t = s.substring(i - size, i)
        if ((res.isEmpty || t < res) && t.replaceAll("0", "").length == k)
          res = t
      })
      if (res.nonEmpty) return res
    })
    ""
  }
}
