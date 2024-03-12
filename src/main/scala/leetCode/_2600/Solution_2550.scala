package leetCode._2600

object Solution_2550 {
  def monkeyMove(n: Int): Int = {
    val M = 1000000007: BigInt
    ((2: BigInt).modPow(n, M) - 2).mod(M).toInt
  }
}
