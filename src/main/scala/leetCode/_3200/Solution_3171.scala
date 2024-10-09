package leetCode._3200

object Solution_3171 {
  def minimumDifference(nums: Array[Int], k: Int): Int = {
    var res = Int.MaxValue
    var left = 0
    var bottom = 0
    var rightOr = 0

    nums.indices.foreach(right => {
      rightOr |= nums(right)
      while (left <= right && (nums(left) | rightOr) > k) {
        res = res.min((nums(left) | rightOr) - k)
        left += 1
        if (bottom < left) {
          (right - 1 to left by -1).foreach(i => nums(i) |= nums(i + 1))
          bottom = right
          rightOr = 0
        }
      }
      if (left <= right) res = res.min(k - (nums(left) | rightOr))
    })
    res
  }
}
