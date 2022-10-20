package leetCode

object Solution_1085 {
  def sumOfDigits(nums: Array[Int]): Int = {
    var min = nums.min
    var res = 0
    while (min != 0) {
      res += min % 10
      min /= 10
    }
    if (res % 2 == 1) 0 else 1
  }
}
