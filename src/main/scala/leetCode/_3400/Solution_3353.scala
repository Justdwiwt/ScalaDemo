package leetCode._3400

object Solution_3353 {
  def minOperations(nums: Array[Int]): Int =
    nums.foldRight(List.empty[Int])((num, stack) => {
      if (stack.nonEmpty && stack.head == num) stack
      else num :: stack
    }).length - 1
}
