package leetCode._3100

object Solution_3085 {
  def minimumDeletions(word: String, k: Int): Int = {
    val m = word.groupBy(identity).mapValues(_.length).values
    if (m.size == 1 || m.min + k >= m.max) return 0
    (m.min + k to m.max).foldLeft(Int.MaxValue)((acc, cur) => {
      (m.filter(_ < cur - k).sum + m.filter(_ > cur).map(_ - cur).sum).min(acc)
    })
  }
}
