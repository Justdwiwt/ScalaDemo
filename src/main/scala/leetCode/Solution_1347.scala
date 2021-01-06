package leetCode

object Solution_1347 {
  def minSteps(s: String, t: String): Int = {
    s.toSeq.diff(t).length
  }
}
