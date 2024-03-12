package leetCode._1500

object Solution_1493 {
  def longestSubarray(nums: Array[Int]): Int = {
    var mx = 0
    var l = 0
    var r = 0
    nums.indices.foreach(i => {
      nums(i) match {
        case 1 => r += 1
        case 0 =>
          l = r
          r = 0
        case _ =>
      }
      mx = mx.max(l + r)
    })
    if (mx == nums.length) mx - 1 else mx
  }
}
