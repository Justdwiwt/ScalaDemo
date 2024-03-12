package leetCode._2700

object Solution_2645 {
  def addMinimum(word: String): Int =
    word./:(0, 'z') { case ((k, pre), cur) => (k + (if (cur <= pre) 1 else 0), cur) }._1 * 3 - word.length
}
