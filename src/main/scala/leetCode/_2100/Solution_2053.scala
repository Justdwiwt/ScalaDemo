package leetCode._2100

object Solution_2053 {
  def kthDistinct(arr: Array[String], k: Int): String = arr
    .filter(x => arr.count(_ == x) == 1)
    .lift(k - 1)
    .getOrElse("")
}
