package leetCode._2200

object Solution_2180 {
  def countEven(num: Int): Int = (1 to num)
    .map(_.toString)
    .toArray
    .map(_.toCharArray.map(_ - '0').sum)
    .count(_ % 2 == 0)
}
