package leetCode._1700

object Solution_1657 {
  def closeStrings(word1: String, word2: String): Boolean = {
    if (word1.length != word2.length) return false
    val a = Array.fill(26)(0)
    val b = Array.fill(26)(0)
    word1.indices.foreach(i => {
      a(word1(i) - 'a') += 1
      b(word2(i) - 'a') += 1
    })
    (0 until 26).foreach(i => if (a(i) == 0 && b(i) != 0 || a(i) != 0 && b(i) == 0) return false)
    a.sorted.sameElements(b.sorted)
  }
}
