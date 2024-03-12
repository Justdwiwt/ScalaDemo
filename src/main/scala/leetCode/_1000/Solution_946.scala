package leetCode._1000

object Solution_946 {
  def validateStackSequences(pushed: Array[Int], popped: Array[Int]): Boolean = {
    @scala.annotation.tailrec
    def f(stack: Seq[Int], idx: Int): (Seq[Int], Int) =
      if (!stack.headOption.contains(popped(idx))) (stack, idx)
      else f(stack.tail, idx + 1)

    pushed
      ./:(Seq.empty[Int], 0) { case ((stack, idx), n) => f(n +: stack, idx) }
      ._1
      .isEmpty
  }
}
