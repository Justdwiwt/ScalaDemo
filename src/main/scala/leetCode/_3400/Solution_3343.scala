package leetCode._3400

object Solution_3343 {
  private val M: Int = 1000000007
  private val MX: Int = 41

  private val arr: Array[Long] = Array.fill(MX)(0L)
  private val INV_F: Array[Long] = Array.fill(MX)(0L)

  initialize()

  private def initialize(): Unit = {
    arr(0) = 1
    (1 until MX).foreach(i => arr(i) = (arr(i - 1) * i) % M)
    INV_F(MX - 1) = pow(arr(MX - 1), M - 2)
    (MX - 1 to 1 by -1).foreach(i => INV_F(i - 1) = (INV_F(i) * i) % M)
  }

  def countBalancedPermutations(num: String): Int = {
    val cnt = Array.fill(10)(0)
    var total = 0
    num.foreach(c => {
      val digit = c.asDigit
      cnt(digit) += 1
      total += digit
    })

    if (total % 2 != 0) return 0

    val n = num.length
    val n1 = n / 2
    val f = Array.fill(n1 + 1, total / 2 + 1)(0)
    f(0)(0) = 1
    var sc = 0
    var s = 0

    (0 until 10).foreach(i => {
      val c = cnt(i)
      sc += c
      s += c * i

      (sc.min(n1) to 0.max(sc - (n - n1)) by -1).foreach(left1 => {
        val left2 = sc - left1

        (s.min(total / 2) to 0.max(s - total / 2) by -1).foreach(leftS => {
          var res = 0L

          (0.max(c - left2) to c.min(left1))
            .withFilter(_ * i <= leftS)
            .foreach(k => res = (res + f(left1 - k)(leftS - k * i).toLong * INV_F(k) % M * INV_F(c - k) % M) % M)

          f(left1)(leftS) = res.toInt
        })
      })
    })

    ((arr(n1) * arr(n - n1) % M * f(n1)(total / 2)) % M).toInt
  }

  private def pow(x: Long, n: Int): Long = {
    var res = 1L
    var base = x
    var exp = n
    while (exp > 0) {
      if (exp % 2 == 1) res = (res * base) % M
      base = (base * base) % M
      exp /= 2
    }
    res
  }
}
