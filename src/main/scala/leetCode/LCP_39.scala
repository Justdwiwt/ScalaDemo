package leetCode

object LCP_39 {
  def minimumSwitchingTimes(source: Array[Array[Int]], target: Array[Array[Int]]): Int = {
    val MX = (1e4 + 50).toInt
    val cnt = Array.fill(MX)(0)
    source.indices.foreach(i => source.head.indices.foreach(j => {
      cnt(source(i)(j)) += 1
      cnt(target(i)(j)) -= 1
    }))
    var res = 0
    (1 until MX).foreach(i => res += cnt(i).abs)
    res /= 2
    res
  }
}
