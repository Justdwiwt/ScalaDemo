package leetCode

object Solution_682 {
  def calPoints(ops: Array[String]): Int = {
    @scala.annotation.tailrec
    def f(ops: Array[String], points: List[Int]): List[Int] = {
      if (ops.isEmpty) return points
      ops.head match {
        case "+" => f(ops.drop(1), (points.head + points.tail.head) :: points)
        case "D" => f(ops.drop(1), (points.head * 2) :: points)
        case "C" => f(ops.drop(1), points.tail)
        case _ => f(ops.drop(1), ops(0).toInt :: points)
      }
    }

    f(ops, List.empty[Int]).sum
  }
}
