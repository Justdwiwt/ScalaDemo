package leetCode

object Solution_1371 {
  def findTheLongestSubstring(s: String): Int = {
    val m = scala.collection.mutable.HashMap[Int, Int]()
    m += (0 -> -1)
    s.indices./:(0, 0)((b, a) => {
      val cur = b._2 ^ 1 << "aeiou".indexOf(s.charAt(a)) + 1 >> 1
      if (!m.contains(cur)) m += cur -> a
      (b._1.max(a - m.getOrElse(cur, 0)), cur)
    })._1
  }
}
