package leetCode

object Offer_006 {
  def twoSum(numbers: Array[Int], target: Int): Array[Int] = {
    var left = 0
    var right = numbers.length - 1
    while (left < right) {
      val sum = numbers(left) + numbers(right)
      if (sum == target) return Array(left, right)
      else if (sum < target) left += 1
      else right -= 1
    }
    Array.empty
  }
}
