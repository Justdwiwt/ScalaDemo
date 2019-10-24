package leetCode

object Solution_189 {
  def rotate(nums: Array[Int], k: Int): Unit = {
    if (k == 0) println(nums)
    else {
      (1 to (k % nums.length)).foreach(_ => {
        val tmp = nums(nums.length - 1)
        (0 to nums.length - 2).reverse.foreach(j => nums(j + 1) = nums(j))
        nums(0) = tmp
      })
    }
  }
}
