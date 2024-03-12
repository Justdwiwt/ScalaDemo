package leetCode._1400

object Solution_1358 {
  def numberOfSubstrings(s: String): Int = {
    var res = 0
    val diff = Array(-1, -1, -1)
    s.indices.foreach(i => {
      s(i) match {
        case 'a' => res += diff(1).min(diff(2)) + 1
        case 'b' => res += diff(0).min(diff(2)) + 1
        case _ => res += diff(0).min(diff(1)) + 1
      }
      diff(s(i) - 'a') = i
    })
    res
  }
}
