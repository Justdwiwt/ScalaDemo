package leetCode

object Offer_014 {
  def checkInclusion(s1: String, s2: String): Boolean = {
    if (s1.length > s2.length) return false
    val cnt = Array.ofDim[Int](26)
    s1.foreach(s => cnt(s - 'a') += 1)
    val found = Array.ofDim[Int](26)
    var start = -1
    (0 until s2.length).foreach(i => {
      found(s2(i) - 'a') += 1
      while (found(s2(i) - 'a') > cnt(s2(i) - 'a')) {
        start += 1
        found(s2(start) - 'a') -= 1
      }
      if (i - start == s1.length) return true
    })
    false
  }
}
