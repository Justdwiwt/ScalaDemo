package leetCode._1700

object Solution_1684 {
  def countConsistentStrings(allowed: String, words: Array[String]): Int =
    words.count(_.forall(allowed.indexOf(_) != -1))
}
