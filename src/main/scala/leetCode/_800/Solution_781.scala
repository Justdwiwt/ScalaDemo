package leetCode._800

object Solution_781 {
  def numRabbits(answers: Array[Int]): Int = answers
    .groupBy(p => p)
    .map(a => (a._1 + 1) * ((a._2.length + a._1) / (a._1 + 1)))
    .sum
}
