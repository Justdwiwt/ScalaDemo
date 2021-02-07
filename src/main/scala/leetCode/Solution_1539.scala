package leetCode

object Solution_1539 {
  def findKthPositive(arr: Array[Int], k: Int): Int =
    arr./:(k)((r, a) => r + (if (a <= r) 1 else 0))
}
