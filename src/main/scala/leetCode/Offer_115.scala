package leetCode

object Offer_115 {
  def sequenceReconstruction(org: Array[Int], seqs: List[List[Int]]): Boolean = {
    val arr = Array.fill(org.length)(0)
    org.indices.foreach(i => arr(org(i) - 1) = i)
    val flag = Array.fill(org.length)(false)
    seqs.foreach(l => {
      var t = -1
      l.indices.foreach(i => {
        var v = l(i).intValue() - 1
        if (v < 0 || v >= org.length) return false
        v = arr(v)
        if (v <= t) return false
        if (v == t + 1) flag(v) = true
        t = v
      })
    })
    org.indices.foreach(i => if (!flag(i)) return false)
    true
  }
}
