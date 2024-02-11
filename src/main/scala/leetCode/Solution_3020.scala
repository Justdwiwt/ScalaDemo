package leetCode

object Solution_3020 {
  def maximumLength(nums: Array[Int]): Int = {
    val numbers = nums.groupBy(identity).mapValues(_.length).toMap.withDefaultValue(0)

    @scala.annotation.tailrec
    def f(number: Int, res: Int): Int = (number, numbers(number)) match {
      case (1, cnt) => if (cnt % 2 != 0) cnt else cnt - 1
      case (_, 0) => res - 1
      case (_, 1) => res + 1
      case (_, _) => f(number * number, res + 2)
    }

    numbers.keys.map(f(_, 0)).max
  }
}
