package leetCode

object Solution_214 {
  def shortestPalindrome(s: String): String = {
    var i = 0
    var end = s.length - 1
    var j = end
    val arr = s.toCharArray
    while (i < j)
      if (arr(i) == arr(j)) {
        i += 1
        j -= 1
      } else {
        i = 0
        end -= 1
        j = end
      }
    new StringBuilder(s.substring(end + 1)).reverse.toString + s
  }
}
