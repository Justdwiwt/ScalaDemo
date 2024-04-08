package leetCode._200

object Solution_167 {
  def twoSum(numbers: Array[Int], target: Int): Array[Int] = {
    @scala.annotation.tailrec
    def f(l: Int, r: Int): Array[Int] = numbers(l) + numbers(r) match {
      case `target` => Array(l + 1, r + 1)
      case t if t > target => f(l, r - 1)
      case _ => f(l + 1, r)
    }

    f(0, numbers.length - 1)
  }
}
