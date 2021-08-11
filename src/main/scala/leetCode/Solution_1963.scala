package leetCode

object Solution_1963 {
  def minSwaps(s: String): Int = math.round(s./:((0, 0))((acc, c) => {
    if (c == '[') (acc._1, acc._2 + 1)
    else if (acc._2 > 0) (acc._1, acc._2 - 1)
    else (acc._1 + 1, acc._2)
  })._1 / 2.0).toInt
}
