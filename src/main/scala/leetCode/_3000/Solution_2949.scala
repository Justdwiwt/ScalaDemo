package leetCode._3000

object Solution_2949 {
  private val mask = 1065233

  def beautifulSubstrings(s: String, k: Int): Long = {
    val kVar = pSqrt(k * 4)
    var cnt = Map.empty[Int, Int]
    val n = s.length
    var sum = n
    cnt += ((kVar - 1) << 17 | sum) -> 1
    var res = 0L
    s.indices.foreach(i => {
      val bit = (mask >> (s.charAt(i) - 'a')) & 1
      sum += bit * 2 - 1
      val key = (i % kVar) << 17 | sum
      cnt.get(key) match {
        case Some(value) => cnt += key -> (value + 1)
        case None => cnt += key -> 1
      }
      res += cnt(key) - 1
    })
    res
  }

  private def pSqrt(n: Int): Int = {
    var res = 1
    var nVar = n
    (2 to math.sqrt(n).toInt).foreach(i => {
      val i2 = i * i
      while (nVar % i2 == 0) {
        res *= i
        nVar /= i2
      }
      if (nVar % i == 0) {
        res *= i
        nVar /= i
      }
    })
    if (nVar > 1) res *= nVar
    res
  }
}
