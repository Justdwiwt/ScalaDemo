package leetCode._3100

object Solution_3014 {
  def minimumPushes(word: String): Int = word
    .distinct
    .grouped(8)
    .zipWithIndex
    .map { case (group, i) => group.length * (i + 1) }
    .sum
}
