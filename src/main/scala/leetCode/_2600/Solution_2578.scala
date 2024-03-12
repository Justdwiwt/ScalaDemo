package leetCode._2600

object Solution_2578 {
  def splitNum(num: Int): Int = num
    .toString
    .toList
    .sorted
    .zipWithIndex
    .filter(_._2 % 2 == 0)
    .map(_._1)
    .mkString
    .toInt + num
    .toString
    .toList
    .sorted
    .zipWithIndex
    .filter(_._2 % 2 == 1)
    .map(_._1)
    .mkString
    .toInt
}
