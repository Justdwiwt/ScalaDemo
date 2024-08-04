package leetCode._3300

object Solution_3221 {
  def maxScore(nums: Array[Int]): Long = {
    @scala.annotation.tailrec
    def process(i: Int, stack: List[Int], acc: Long): Long = {
      if (i >= nums.length) calculateScore(stack, acc)
      else if (stack.nonEmpty && nums(stack.head) <= nums(i)) process(i, stack.tail, acc)
      else process(i + 1, i :: stack, acc)
    }

    @scala.annotation.tailrec
    def calculateScore(stack: List[Int], acc: Long): Long = stack match {
      case curr :: rest =>
        val prev = if (rest.nonEmpty) rest.head else 0
        calculateScore(rest, acc + (curr - prev).toLong * nums(curr))
      case Nil => acc
    }

    process(1, List(0), 0L)
  }
}
