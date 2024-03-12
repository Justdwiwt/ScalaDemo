package leetCode._2200

object Solution_2177 {
  def sumOfThree(num: Long): Array[Long] =
    if (num % 3 == 0) Array(num / 3 - 1, num / 3, num / 3 + 1)
    else Array()
}
