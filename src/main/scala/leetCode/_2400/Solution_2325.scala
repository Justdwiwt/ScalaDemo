package leetCode._2400

object Solution_2325 {
  def decodeMessage(key: String, message: String): String = message.map(('a' to 'z')
    .sortBy(key.indexOf(_))
    .zip('a' to 'z')
    .toMap + (' ' -> ' '))
}
