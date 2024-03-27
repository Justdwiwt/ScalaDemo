package leetCode._1400

object Solution_1399 {
  def countLargestGroup(n: Int): Int = (1 to n)
    .groupBy(_.toString.toList.map(_.toString.toInt).sum)
    .values
    .groupBy(_.length)
    .maxBy(_._1)
    ._2
    .size
}
