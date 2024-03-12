package leetCode._1900

object Solution_1864 {
  def minSwaps(s: String): Int = {
    val len = s.length
    var oddCount = 0
    var evenCount = 0
    s.indices.foreach(i => if (s.charAt(i) == '1') {
      if (i % 2 == 0) evenCount += 1
      else oddCount += 1
    })
    if (len % 2 == 0) f(evenCount, oddCount, len)
    else g(evenCount, oddCount, len)
  }

  def f(evenCount: Int, oddCount: Int, len: Int): Int = {
    if (oddCount + evenCount != len / 2) return -1
    oddCount.min(evenCount)
  }

  def g(evenCount: Int, oddCount: Int, len: Int): Int = {
    if (oddCount + evenCount != len / 2 && oddCount + evenCount != len / 2 + 1) -1
    else if (oddCount + evenCount == len / 2) evenCount
    else oddCount
  }
}
