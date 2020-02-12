package leetCode

object Offer_11 {
  def minArray(numbers: Array[Int]): Int = {
    var l = 0
    var r = numbers.length - 1
    while (l < r) {
      val m = (l + r) / 2
      if (numbers(m) < numbers(r)) r = m
      else if (numbers(m) > numbers(r)) l = m + 1
      else r -= 1
    }
    numbers(l)
  }
}
