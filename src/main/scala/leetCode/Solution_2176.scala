package leetCode

object Solution_2176 {
  def countPairs(nums: Array[Int], k: Int): Int = {
    var cnt = 0
    nums.indices.foreach(i => (i + 1 until nums.length).foreach(j => if (nums(i) == nums(j) && (i * j) % k == 0) cnt += 1))
    cnt
  }
}
