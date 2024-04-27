package leetCode._1900

object Solution_1842 {
  def nextPalindrome(num: String): String = {
    val n = num.length
    if (n < 3) return ""
    val ch = num.toCharArray
    var mid = n / 2 - 1
    var l = mid
    while (l - 1 >= 0 && ch(l - 1) >= ch(l)) l -= 1
    if (l == 0) return ""
    while (mid > l && ch(mid) <= ch(l - 1)) mid -= 1
    swap(ch, mid, l - 1)
    swap(ch, n - 1 - mid, n - l)
    mid = n / 2
    java.util.Arrays.sort(ch, l, mid)
    (l until mid).foreach(i => ch(n - 1 - i) = ch(i))
    new String(ch)
  }

  private def swap(chars: Array[Char], i: Int, j: Int): Unit = {
    val temp = chars(i)
    chars(i) = chars(j)
    chars(j) = temp
  }
}
