package leetCode._1800

object Solution_1734 {
  def decode(encoded: Array[Int]): Array[Int] = {
    val total = (1 to encoded.length + 1).reduce(_ ^ _)
    val res = Array.fill(encoded.length + 1)(0)
    res(0) = total ^ encoded.indices.drop(1).by(2).map(encoded).reduce(_ ^ _)
    res.indices.drop(1).foreach(i => res(i) = res(i - 1) ^ encoded(i - 1))
    res
  }
}
