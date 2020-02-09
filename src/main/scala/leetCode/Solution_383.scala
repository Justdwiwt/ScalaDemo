package leetCode

object Solution_383 {
  def canConstruct(ransomNote: String, magazine: String): Boolean = {
    if (magazine.length < ransomNote.length) return false
    val arr = Array.fill(26)(0)
    ransomNote.toCharArray.foreach(c => {
      val idx = magazine.indexOf(c, arr(c - 'a'))
      if (idx == -1) return false
      arr(c - 97) = idx + 1
    })
    true
  }
}
