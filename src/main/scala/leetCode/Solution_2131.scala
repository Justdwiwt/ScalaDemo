package leetCode

object Solution_2131 {
  def longestPalindrome(words: Array[String]): Int = {
    val arr = Array.fill(26, 26)(0)
    words.indices.foreach(i => arr(words(i).head - 'a')(words(i)(1) - 'a') += 1)
    var res = 0
    var flag = false
    (0 until 26).foreach(i => (i until 26).foreach(j => {
      if (j == i) {
        if ((arr(i)(j) & 1) > 0) flag = true
        res += 2 * (arr(i)(j) & (~1))
      } else res += 4 * arr(i)(j).min(arr(j)(i))
    }))
    if (flag) res += 2
    res
  }
}
