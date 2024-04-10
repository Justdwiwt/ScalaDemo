package leetCode._3100

object Solution_3073 {
  def maximumTripletValue(nums: Array[Int]): Int = {
    val n = nums.length
    val sorted = nums.indices.sortBy(nums(_))
    var res = 0

    sorted.zipWithIndex.foreach { case (x, i) =>
      var left = 0
      var j = i - 1
      while (j >= 0 && (sorted(j) >= x || nums(sorted(j)) == nums(x)))
        j -= 1
      if (j >= 0 && j < i)
        left = nums(sorted(j)) - nums(x)
      if (left == 0) {
      } else {
        j = n - 1
        while (j > i && sorted(j) <= x)
          j -= 1
        if (j > i && nums(sorted(j)) > nums(x))
          res = res.max(left + nums(sorted(j)))
      }
    }
    res
  }
}
