package leetCode

object Solution_485 {
  def findMaxConsecutiveOnes(nums: Array[Int]): Int = {
    val ret = nums.foldLeft((0, 0))((t, e) => {
      if (e == 1) (t._1, t._2 + 1) else (t._1.max(t._2), 0)
    })
    ret._1.max(ret._2)
  }
}
