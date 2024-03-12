package leetCode._1500

object Solution_1433 {
  def checkIfCanBreak(s1: String, s2: String): Boolean = {
    val t1 = s1.sorted
    val t2 = s2.sorted
    var f1 = true
    var f2 = true
    t1.indices.foreach(i => {
      if (f1 && t1(i) < t2(i)) f1 = false
      if (f2 && t1(i) > t2(i)) f2 = false
      if (!f1 && !f2) return false
    })
    true
  }
}
