package leetCode

object Solution_1253 {
  def reconstructMatrix(upper: Int, lower: Int, colsum: Array[Int]): List[List[Int]] = {
    var res = List.empty[List[Int]]
    var a = List.fill(upper)(1)
    var b = List.empty[Int]
    (0 until colsum.length - upper).foreach(_ => a :+= 0)
    colsum.indices.foreach(i => b :+= (colsum(i) - a(i)))
    if (b.sum == lower) {
      res :+= a
      res :+= b
    }
    res
  }
}
