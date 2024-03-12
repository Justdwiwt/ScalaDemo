package leetCode._1100

object Solution_1016 {
  def queryString(S: String, N: Int): Boolean = {
    (1 to N).foreach(i => if (!S.contains(Integer.toBinaryString(i))) return false)
    true
  }
}
