package leetCode._4000

object Solution_3922 {
  def minFlips(s: String): Int = {
    val c0 = s.count(_ == '0')
    c0.min((s.length - c0 - 1 - (if (s.head == '1' && s.last == '1') 1 else 0)).max(0))
  }
}
