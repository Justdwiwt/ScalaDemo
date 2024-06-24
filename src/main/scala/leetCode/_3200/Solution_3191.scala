package leetCode._3200

object Solution_3191 {
  def minOperations(nums: Array[Int]): Int = {
    val n = nums.length

    def flip(arr: Array[Int], i1: Int, i2: Int): Unit = {
      arr(i1) ^= 1
      arr(i2) ^= 1
    }

    var count = 0

    nums.indices.dropRight(2).foreach(i => if (nums(i) == 0) {
      flip(nums, i + 1, i + 2)
      count += 1
    })

    if (nums(n - 2) != 0 && nums(n - 1) != 0) count else -1
  }
}
