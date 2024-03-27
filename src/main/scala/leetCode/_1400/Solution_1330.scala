package leetCode._1400

object Solution_1330 {
  def maxValueAfterReverse(nums: Array[Int]): Int = {
    var sum = 0
    nums.indices.dropRight(1).foreach(i => sum += (nums(i + 1) - nums(i)).abs)
    var mx = 0
    nums.indices.drop(1).dropRight(1).foreach(i => {
      mx = mx.max(-(nums(i + 1) - nums(i)).abs + (nums(i + 1) - nums.head).abs)
      mx = mx.max(-(nums(i) - nums(i - 1)).abs + (nums(nums.length - 1) - nums(i - 1)).abs)
    })
    var a = Int.MinValue
    var b = Int.MaxValue
    nums.indices.dropRight(1).foreach(i => {
      a = a.max(nums(i).min(nums(i + 1)))
      b = b.min(nums(i).max(nums(i + 1)))
    })
    sum + mx.max(2 * (a - b))
  }
}
