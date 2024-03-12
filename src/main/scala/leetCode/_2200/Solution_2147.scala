package leetCode._2200

object Solution_2147 {
  def numberOfWays(corridor: String): Int = {
    val filtered = corridor.indices.filter(corridor(_) == 'S')
    if (filtered.length % 2 == 1 || filtered.isEmpty) 0
    else (2 until filtered.length by 2)./:(1L, filtered(1)) {
      case ((ways, prev), i) =>
        val length = filtered(i) - prev
        ((ways * length) % 1000000007, filtered(i + 1))
    }._1.toInt
  }
}
