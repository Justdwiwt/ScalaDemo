package leetCode

object Solution_2443 {
  def sumOfNumberAndReverse(num: Int): Boolean = (0 to num)
    .exists(x => x.toString.reverse.toInt + x == num)
}
