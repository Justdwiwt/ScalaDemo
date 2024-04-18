package leetCode._3200

object Solution_3119 {
  def maxPotholes(road: String, budget: Int): Int = road
    .split("\\.")
    .map(_.length)
    .filter(_ > 0)
    .sorted
    .reverse
    .foldLeft((0, budget))((acc, length) => {
      if (acc._2 > 0)
        if (length + 1 <= acc._2) (acc._1 + length, acc._2 - (length + 1))
        else (acc._1 + (acc._2 - 1), 0)
      else acc
    })
    ._1
}
