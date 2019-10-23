package leetCode

object Solution_75 {
  def sortColors(nums: Array[Int]): Unit = {
    nums.indices.foreach(i => {
      (i + 1 until nums.length).foreach(j => {
        if (nums(i) > nums(j)) {
          val temp = nums(j)
          nums(j) = nums(i)
          nums(i) = temp
        }
      })
    })
  }
}
