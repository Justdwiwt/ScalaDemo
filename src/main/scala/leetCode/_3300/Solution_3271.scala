package leetCode._3300

object Solution_3271 {
  def stringHash(s: String, k: Int): String = s
    .toCharArray
    .grouped(k)
    .map(sub => {
      val hash = sub.map(_ - 'a').sum % 26
      ('a' + hash).toChar
    })
    .foldLeft("")((x: String, y: Char) => x + y.toString)
}
