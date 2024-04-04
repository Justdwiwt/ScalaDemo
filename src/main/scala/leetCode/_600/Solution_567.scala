package leetCode._600

object Solution_567 {
  def checkInclusion(s1: String, s2: String): Boolean = {
    s2.sliding(s1.length).exists(s1.sorted == _.sorted)
  }
}
