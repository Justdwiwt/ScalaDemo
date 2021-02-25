package leetCode

object Solution_1716 {
  def totalMoney(n: Int): Int =
    (0 until n)./:(0)((b, a) => b + a / 7 + a % 7 + 1)
}
