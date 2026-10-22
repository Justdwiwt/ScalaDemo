package leetCode._4100

object Solution_4026 {
  def maximumGap(skill: String, station: String): Int = {
    val n = skill.length
    val suf = Array.fill(n)(0)
    var j = station.length - 1

    (n - 1 to 1 by -1).foreach(i => {
      while (station(j) != skill(i)) j -= 1
      suf(i) = j
      j -= 1
    })

    skill.indices.dropRight(1).foldLeft((0, 0)) {
      case ((pre, ans), i) =>
        val p = station.indexOf(skill(i), pre)
        (p + 1, ans.max(suf(i + 1) - p))
    }._2
  }
}
