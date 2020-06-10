package leetCode

object Solution_1347 {
  def minSteps(s: String, t: String): Int = {
    var res = 0
    val arr = Array.fill(26)(0)
    s.foreach(i => arr(i - 'a') += 1)
    t.foreach(i => arr(i - 'a') -= 1)
    arr.foreach(i => if (i > 0) res += i)
    res
  }
}
