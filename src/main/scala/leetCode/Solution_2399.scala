package leetCode

object Solution_2399 {
  def checkDistances(s: String, distance: Array[Int]): Boolean = {
    val arr = Array.fill(26)(-1)
    s.indices.foreach(i => {
      val a = s(i) - 'a'
      if (arr(a) == -1) arr(a) = i
      else if (i - arr(a) - 1 != distance(a)) return false
    })
    true
  }
}
