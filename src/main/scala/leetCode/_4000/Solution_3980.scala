package leetCode._4000

object Solution_3980 {
  def minOperations(s1: String, s2: String): Int =
    if (s1 == "1" && s2 == "0") -1
    else {
      val s = s1.toCharArray

      s.indices.foldLeft(0)((ans, i) => {
        if (s(i) == s2(i)) ans
        else if (s(i) == '0') ans + 1
        else if (i + 1 < s.length && s(i + 1) == '1') {
          s(i + 1) = '0'
          ans + 1
        } else ans + 2
      })
    }
}
