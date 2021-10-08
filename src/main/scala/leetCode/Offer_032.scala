package leetCode

object Offer_032 {
  def isAnagram(s: String, t: String): Boolean = {
    val m = s.length
    val n = t.length
    if (m != n || s.equals(t)) return false
    val arr = Array.fill(26)(0)
    s.indices.foreach(i => {
      arr(s(i) - 'a') += 1
      arr(t(i) - 'a') -= 1
    })
    arr.foreach(i => if (i != 0) return false)
    true
  }
}
