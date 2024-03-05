package leetCode

object LCP_66 {
  def minNumBooths(demand: Array[String]): Int = {
    val cnt = Array.fill(26)(0)
    demand.foreach(x => {
      val tmp = Array.fill(26)(0)
      x.toCharArray.foreach(x => tmp(x - 'a') += 1)
      cnt.indices.map(i => cnt(i) = tmp(i).max(cnt(i)))
    })
    cnt.sum
  }
}
