package leetCode._400

object Solution_334 {
  def increasingTriplet(nums: Array[Int]): Boolean = {
    nums./:((Int.MaxValue, Int.MaxValue)) { case ((a, b), i) =>
      if (i < a) (i, b)
      else if (i > a && i < b) (a, i)
      else if (i > b) return true
      else (a, b)
    }
    false
  }
}
