package leetCode

object Solution_2954 {
  val M: Int = (1e9 + 7).toInt
  private var fac = Array.empty[Long]

  def numberOfSequence(n: Int, sick: Array[Int]): Int = {
    val m = sick.length
    var rem = n - m
    fac = Array.fill(n + 5)(0L)
    fac(0) = 1
    (1 to n).foreach(i => fac(i) = fac(i - 1) * i % M)
    var res = comb(rem, sick(0))
    (1 until m).foreach(i => res = res * pow(2, 0.max(sick(i) - sick(i - 1) - 2)) % M)
    rem -= sick.head
    (1 until m).foreach(i => {
      res = res * comb(rem, sick(i) - sick(i - 1) - 1) % M
      rem -= sick(i) - sick(i - 1) - 1
    })
    res.toInt
  }

  private def comb(a: Int, b: Int): Long = {
    fac(a) * pow(fac(b), M - 2) % M * pow(fac(a - b), M - 2) % M
  }

  private def pow(a: Long, b: Int): Long = {
    var res = 1L
    var p = b
    var q = a
    while (p != 0) {
      if ((p & 1) == 1) res = res * q % M
      p >>= 1
      q = q * q % M
    }
    res
  }
}
