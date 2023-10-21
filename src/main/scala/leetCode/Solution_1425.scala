package leetCode

object Solution_1425 {
  def constrainedSubsetSum(nums: Array[Int], k: Int): Int = {
    var dq = Array.emptyIntArray
    nums.indices.foreach(i => {
      if (dq.nonEmpty) nums(i) = nums(i) + nums(dq.head)
      while (dq.nonEmpty && (i - dq.head >= k || nums(i) >= nums(dq.last))) {
        if (nums(i) >= nums(dq.last)) dq.drop(dq.last)
        else dq.drop(0)
      }
      if (nums(i) > 0) dq :+= 0
    })
    nums.max
  }
}
