package leetCode._300

object Solution_277 {
  def knows(a: Int, b: Int): Boolean = ???

  def findCelebrity(n: Int): Int = {
    val candidate = (1 until n).foldLeft(0)((res, i) => if (knows(res, i)) i else res)
    if ((0 until n).exists(i => candidate != i && (knows(candidate, i) || !knows(i, candidate)))) -1
    else candidate
  }
}
