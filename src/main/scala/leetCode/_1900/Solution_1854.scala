package leetCode._1900

object Solution_1854 {
  def maximumPopulation(logs: Array[Array[Int]]): Int = logs
    .fold(new Array[Int](2050 - 1950)) { (acc, v) =>
      (v.head until v(1)).foreach(x => acc(x - 1950) += 1)
      acc
    }.zipWithIndex.maxBy(_._1)._2 + 1950
}
