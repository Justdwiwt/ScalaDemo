package leetCode

object Solution_893 {
  def numSpecialEquivGroups(A: Array[String]): Int = A.groupBy(str => {
    str.zipWithIndex.filter(_._2 % 2 == 0).map(_._1).mkString + str.zipWithIndex.filter(_._2 % 2 != 0).map(_._1).mkString
  }).size
}
