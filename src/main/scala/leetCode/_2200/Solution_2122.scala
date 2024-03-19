package leetCode._2200

object Solution_2122 {
  def recoverArray(nums: Array[Int]): Array[Int] = {
    val sorted = nums.sorted
    val counter = sorted.groupBy(identity).mapValues(_.length).withDefaultValue(0)

    def check(diff: Int): Option[Array[Int]] = Some(sorted.foldLeft(counter, Array.empty[Int]) { case ((cnt, res), n) =>
        if (cnt(n) == 0) (cnt, res)
        else if (cnt(n + diff) == 0) return None
        else (cnt.updated(n, cnt(n) - 1).updated(n + diff, cnt(n + diff) - 1), res :+ (n + diff / 2))
      }
      ._2
    )

    sorted
      .indices
      .drop(1)
      .view
      .map(sorted(_) - sorted.head)
      .filter(diff => diff != 0 && diff % 2 == 0)
      .flatMap(check)
      .head
  }
}
