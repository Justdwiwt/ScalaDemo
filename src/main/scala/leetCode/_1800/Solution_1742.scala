package leetCode._1800

object Solution_1742 {
  def countBalls(lowLimit: Int, highLimit: Int): Int = (lowLimit to highLimit)
    .map(_.toString.toList.map(_.asDigit).sum)
    .groupBy(identity)
    .mapValues(_.size)
    .maxBy(_._2)
    ._2
}
