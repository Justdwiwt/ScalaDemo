package leetCode.LCP

object LCP_77 {
  def runeReserve(runes: Array[Int]): Int = {
    val sorted = runes.sorted
    var res = 1
    var cnt = 1
    runes.indices.drop(1).foreach(i =>
      if (sorted(i) - sorted(i - 1) > 1) cnt = 1
      else {
        cnt = cnt + 1
        res = res.max(cnt)
      })
    res
  }
}
