package leetCode._1400

object Solution_1380 {
  def luckyNumbers(matrix: Array[Array[Int]]): List[Int] = {
    val col = matrix.map(x => x.indexOf(x.min))
    val row = matrix.head.indices.map(x => matrix.indices.map(matrix(_)(x))).map(x => x.indexOf(x.max))
    matrix.head.indices.filter(x => col(row(x)) == x).map(x => matrix(row(x))(x)).toList
  }
}
