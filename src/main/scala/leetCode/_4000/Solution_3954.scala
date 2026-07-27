package leetCode._4000

object Solution_3954 {
  def sumOfGoodIntegers(n: Int, k: Int): Int =
    (1.max(n - k) to n + k).filter(v => (n & v) == 0).sum
}
