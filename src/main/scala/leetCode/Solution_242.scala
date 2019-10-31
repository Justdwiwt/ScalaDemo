package leetCode

object Solution_242 {
  def isAnagram(s: String, t: String): Boolean = {
    s.sorted == t.sorted
  }
}
