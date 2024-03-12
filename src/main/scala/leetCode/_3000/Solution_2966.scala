package leetCode._3000

object Solution_2966 {
  def divideArray(nums: Array[Int], k: Int): Array[Array[Int]] = {
    val res = nums.sorted.sliding(3, 3).toArray
    if (res.forall(n => (n(2) - n.head) <= k)) res else Array.empty
  }
}
