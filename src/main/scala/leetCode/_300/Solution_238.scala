package leetCode._300

object Solution_238 {
  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    val l = nums.scanLeft(1)(_ * _).dropRight(1)
    val r = nums.scanRight(1)(_ * _).tail
    l.zip(r).map({ case (l, r) => l * r })
  }
}
