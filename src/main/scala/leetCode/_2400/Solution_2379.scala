package leetCode._2400

object Solution_2379 {
  def minimumRecolors(blocks: String, k: Int): Int = blocks
    .sliding(k)
    .map(_.count(_ == 'W'))
    .min
}
