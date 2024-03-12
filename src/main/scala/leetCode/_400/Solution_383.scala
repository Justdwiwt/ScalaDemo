package leetCode._400

object Solution_383 {
  def canConstruct(ransomNote: String, magazine: String): Boolean =
    ransomNote.intersect(magazine) == ransomNote
}
