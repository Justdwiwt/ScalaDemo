package leetCode._3000

object Solution_2904 {
  def shortestBeautifulSubstring(s: String, k: Int): String = (k to s.length)
    .find(size => (0 to s.length - size).exists(i => s.substring(i, i + size).count(_ == '1') == k))
    .map(size => (0 to s.length - size).map(i => s.substring(i, i + size)).filter(_.count(_ == '1') == k).min)
    .getOrElse("")
}
