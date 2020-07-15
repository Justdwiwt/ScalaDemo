package leetCode

object Solution_1505 {
  def minInteger(num: String, k: Int): String = {
    if (k == 0) return num
    if (k > num.length * (num.length - 1) / 2) return num.sorted
    ('0' to '9').foreach(c => {
      val i = num.indexOf(c)
      if (i >= 0 && i <= k)
        return c + minInteger(num.substring(0, i) + num.substring(i + 1), k - i)
    })
    num
  }
}
