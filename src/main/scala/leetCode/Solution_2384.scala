package leetCode

object Solution_2384 {
  def largestPalindromic(num: String): String = {
    val counts = num.groupBy(identity).mapValues(_.length).withDefaultValue(0)

    val center = "9876543210".find(digit => counts(digit) % 2 == 1)
    val leftHalf = "9876543210"
      .flatMap(digit => digit.toString * (counts(digit) / 2))
      .dropWhile(_ == '0')

    val result = leftHalf ++ center ++ leftHalf.reverse
    if (result.isEmpty) "0" else result
  }
}
