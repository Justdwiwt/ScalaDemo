package leetCode

object Solution_485 {
  def findMaxConsecutiveOnes(nums: Array[Int]): Int = {
    val ret = nums.foldLeft((0, 0))((t, e) => {
      if (e == 1) (t._1, t._2 + 1) else (Math.max(t._1, t._2), 0)
    })
    Math.max(ret._1, ret._2)
  }
}
