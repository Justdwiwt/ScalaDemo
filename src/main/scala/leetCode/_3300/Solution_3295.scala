package leetCode._3300

object Solution_3295 {
  def reportSpam(message: Array[String], bannedWords: Array[String]): Boolean =
    message.count(bannedWords.toSet.contains) > 1
}
