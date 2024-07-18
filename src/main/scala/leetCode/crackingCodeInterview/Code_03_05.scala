package leetCode.crackingCodeInterview

object Code_03_05 {
  class SortedStack {
    private var stack: List[Int] = Nil

    def push(value: Int): Unit =
      stack = sortInsert(value, stack)

    def pop(): Unit = stack match {
      case _ :: tail => stack = tail
      case Nil =>
    }

    def peek(): Int =
      stack.headOption.getOrElse(-1)

    def isEmpty: Boolean =
      stack.isEmpty

    private def sortInsert(value: Int, st: List[Int]): List[Int] = st match {
      case Nil => List(value)
      case head :: tail =>
        if (value <= head) value :: head :: tail
        else head :: sortInsert(value, tail)
    }
  }
}
