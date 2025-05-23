package leetCode._3600

object Solution_3542 {
  def minOperations(nums: Array[Int]): Int = {
    val (res, finalStack) = nums.foldLeft((0, List.empty[Int])) {
      case ((acc, st), x) =>
        val (popped, rest) = st.span(_ > x)
        val newAcc = acc + popped.length
        val newStack = rest match {
          case head :: _ if head == x => rest
          case _ => x :: rest
        }
        (newAcc, newStack)
    }
    val residual = finalStack.length
    val bottomIsZero = finalStack.nonEmpty && finalStack.last == 0
    res + residual - (if (bottomIsZero) 1 else 0)
  }
}
