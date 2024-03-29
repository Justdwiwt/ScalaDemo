package leetCode._1200

object Solution_1163 {
  def lastSubstring(s: String): String = s.substring(s.indices.reverse.foldLeft(s.length - 1)((mx, cur) => {
    if (s.charAt(cur) > s.charAt(mx)) cur
    else if (s.charAt(cur) == s.charAt(mx)) {
      var i = cur + 1
      var j = mx + 1
      while (i < mx && j < s.length && s.charAt(i) == s.charAt(j)) {
        i += 1
        j += 1
      }
      if (i == mx || j == s.length || s.charAt(i) > s.charAt(j)) cur
      else mx
    }
    else mx
  }))
}
