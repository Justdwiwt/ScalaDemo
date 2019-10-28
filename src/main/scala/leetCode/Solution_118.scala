package leetCode

object Solution_118 {
  def generate(numRows: Int): List[List[Int]] = (List(List(1)) /: (1 to numRows)) ((a, _) => a :+ (1 +: (a.last zip a.last.slice(1, a.last.length)).map { case (x, y) => x + y } :+ 1)).dropRight(1)
}
