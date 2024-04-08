package leetCode._200

object Solution_118 {
  def generate(numRows: Int): List[List[Int]] = (1 to numRows)
    ./:(List(List(1)))((a, _) => a :+ (1 +: a.last.zip(a.last.slice(1, a.last.length)).map { case (x, y) => x + y } :+ 1))
    .dropRight(1)
}
