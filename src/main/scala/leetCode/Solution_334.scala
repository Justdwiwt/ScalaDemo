package leetCode

object Solution_334 {
  def increasingTriplet(nums: Array[Int]): Boolean = {
    var a = Int.MaxValue
    var b = a
    nums.foreach(v => {
      if (v <= a) a = v
      else if (v <= b) b = v
      else return true
    })
    false
  }
}
