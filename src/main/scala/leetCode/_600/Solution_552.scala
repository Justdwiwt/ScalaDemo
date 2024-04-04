package leetCode._600

object Solution_552 {
  def checkRecord(n: Int): Int = {
    var dp = Array(1, 1, 0, 1, 0, 0)

    def sum(l: Int, h: Int): Int =
      (l to h).foldLeft(0)((ac, i) => (ac + dp(i)) % 1000000007)

    (2 to n).foreach(_ => dp = Array(sum(0, 2), dp.head, dp(1), sum(0, 5), dp(3), dp(4)))
    sum(0, 5)
  }
}
