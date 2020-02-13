package leetCode

object Offer_15 {
  def hammingWeight(n: Int): Int = {
    var res = 0
    var t = n
    (0 until 32).foreach(_ => {
      res += t & 1
      t >>= 1
    })
    res
  }
}
