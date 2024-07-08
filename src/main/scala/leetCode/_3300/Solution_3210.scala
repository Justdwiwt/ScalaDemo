package leetCode._3300

object Solution_3210 {
  def getEncryptedString(s: String, k: Int): String =
    s.indices.map(i => s((i + k) % s.length)).mkString
}
