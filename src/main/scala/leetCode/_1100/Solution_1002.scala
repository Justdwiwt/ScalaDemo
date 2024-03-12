package leetCode._1100

object Solution_1002 {
  def commonChars(A: Array[String]): List[String] = A
    ./:(A.head)(_.intersect(_))
    .toList
    .map(_.toString)
}
