package leetCode._2100

object Solution_2080 {
  final case class Solver(arrMap: Array[Map[Int, Int]])

  object Solver {
    def apply(_arr: Array[Int]): Solver = {
      val arrMap = _arr.scanLeft(Map.empty[Int, Int]) { case (map, number) =>
        map.get(number) match {
          case Some(value) => map.updated(number, value + 1)
          case None => map.updated(number, 1)
        }
      }
      Solver(arrMap.tail)
    }

    def query(solver: Solver)(left: Int, right: Int, value: Int): Int = {
      val rightVal = solver.arrMap(right).getOrElse(value, 0)
      val leftVal = if (left == 0) 0
      else solver.arrMap(left - 1).getOrElse(value, 0)
      rightVal - leftVal
    }
  }

  class RangeFreqQuery(_arr: Array[Int]) {
    private val solver: Solver = Solver(_arr)

    def query(left: Int, right: Int, value: Int): Int = {
      Solver.query(solver)(left, right, value)
    }

  }
}
