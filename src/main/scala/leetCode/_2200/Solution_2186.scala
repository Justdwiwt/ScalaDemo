package leetCode._2200

object Solution_2186 {
  def minSteps(s: String, t: String): Int = {
    val arr = Array.fill(26)(0)
    s.indices.foreach(i => arr(s(i) - 'a') += 1)
    t.indices.foreach(i => arr(t(i) - 'a') -= 1)
    arr.map(_.abs).sum
  }
}
