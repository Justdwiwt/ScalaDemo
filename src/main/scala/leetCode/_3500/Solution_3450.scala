package leetCode._3500

object Solution_3450 {
  def maxStudentsOnBench(students: Array[Array[Int]]): Int = students
    .groupBy(_(1))
    .values
    .map(_.map(_.head).toSet.size)
    .reduceOption(_.max(_))
    .getOrElse(0)
}
