package leetCode._2100

object Solution_2068 {
  def checkAlmostEquivalent(word1: String, word2: String): Boolean = {
    val a1, a2 = Array.fill(26)(0)
    word1.toCharArray.foreach(x => a1(x - 'a') += 1)
    word2.toCharArray.foreach(x => a2(x - 'a') += 1)
    (0 until 26).foreach(i => if ((a1(i) - a2(i)).abs > 3) return false)
    true
  }
}
