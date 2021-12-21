package leetCode

object Solution_2091 {
  def minimumDeletions(nums: Array[Int]): Int = {
    var a = 0
    var b = 0
    nums.indices.drop(1).foreach(i => {
      if (nums(i) > nums(a)) a = i
      if (nums(i) < nums(b)) b = i
    })
    (a.max(b) + 1).min(nums.length - a.min(b)).min((a + 1 + nums.length - b).min(b + 1 + nums.length - a))
  }
}
