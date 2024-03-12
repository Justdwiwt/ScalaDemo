package leetCode._1900

object Solution_1803 {
  def countPairs(nums: Array[Int], low: Int, high: Int): Int = {
    var res = 0
    nums.indices.dropRight(1).foreach(i => {
      val x = nums(i)
      (i + 1 until nums.length).foreach(j => {
        val r = nums(j) ^ x
        if (r >= low && r <= high) res += 1
      })
    })
    res
  }
}
