package leetCode._1200

object Solution_1196 {
  def maxNumberOfApples(weight: Array[Int]): Int =
    weight.sorted.foldLeft((0, 0)) { case ((cnt, cur), wei) =>
      if (cur + wei > 5000) (cnt, cur)
      else (cnt + 1, cur + wei)
    }._1
}
