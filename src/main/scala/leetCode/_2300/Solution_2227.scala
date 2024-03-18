package leetCode._2300

object Solution_2227 {
  class Encrypter(_keys: Array[Char], _values: Array[String], _dictionary: Array[String]) {
    private val keyIndices = _keys.zipWithIndex.toMap
    private val encCounts = _dictionary
      .map(encrypt)
      .foldLeft(Map.empty[String, Int].withDefaultValue(0))((cnt, s) => cnt.updated(s, cnt(s) + 1))

    def encrypt(word: String): String = word
      .map(c => _values(keyIndices(c)))
      .mkString

    def decrypt(word: String): Int =
      encCounts(word)
  }
}
