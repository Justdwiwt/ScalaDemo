package leetCode._3000

object Solution_2961 {
  def getGoodIndices(variables: Array[Array[Int]], target: Int): List[Int] = variables
    .zipWithIndex
    .filter(n => (BigInt(n._1.head).pow(n._1(1)) % 10).pow(n._1(2)) % n._1(3) == target)
    .map(_._2)
    .toList
}
