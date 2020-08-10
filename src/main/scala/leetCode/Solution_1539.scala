package leetCode

object Solution_1539 {
  def findKthPositive(arr: Array[Int], k: Int): Int = {
    arr.indices.foreach(i => if (arr(i) - i - 1 >= k) return k + i)
    k + arr.length
  }
}
