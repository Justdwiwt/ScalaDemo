package leetCode

object Solution_1663 {
  def getSmallestString(n: Int, k: Int): String = {
    val s = Array.fill(n)('a')
    val cnt = (k - n) / 25
    val head = (k - n) % 25
    s(n - cnt - 1) = ('a'.toInt + head).toChar
    (n - cnt until n).foreach(i => s(i) = 'z')
    s.mkString
  }
}
