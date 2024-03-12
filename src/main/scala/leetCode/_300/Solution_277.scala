package leetCode._300

object Solution_277 {
  def knows(a: Int, b: Int): Boolean = ???

  def findCelebrity(n: Int): Int = {
    var res = 0
    (1 until n).foreach(i => if (knows(res, i)) res = i)
    (0 until n).foreach(i => if (res != i && (knows(res, i) || !knows(i, res))) return -1)
    res
  }
}
