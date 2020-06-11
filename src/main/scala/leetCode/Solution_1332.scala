package leetCode

object Solution_1332 {
  def removePalindromeSub(s: String): Int = {
    (0 until s.length / 2).foreach(i => if (s(i) != s(s.length - 1 - i)) return 2)
    if (s.length - 1 == -1) 0 else 1
  }
}
