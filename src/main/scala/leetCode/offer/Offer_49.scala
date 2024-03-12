package leetCode.offer

object Offer_49 {
  def nthUglyNumber(n: Int): Int = {
    var arr = Array(1)
    var idx2 = 0
    var idx3 = 0
    var idx5 = 0
    (1 until n).foreach(_ => {
      arr = arr :+ (arr(idx2) * 2).min(arr(idx3) * 3).min(arr(idx5) * 5)
      if (arr.last == arr(idx2) * 2) idx2 += 1
      if (arr.last == arr(idx3) * 3) idx3 += 1
      if (arr.last == arr(idx5) * 5) idx5 += 1
    })
    arr.last
  }
}
