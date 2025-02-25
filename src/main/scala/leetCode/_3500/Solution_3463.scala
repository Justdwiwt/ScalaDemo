package leetCode._3500

object Solution_3463 {
  val MX = 5
  val arr: Array[Array[Int]] = Array.ofDim[Int](MX, MX)

  (0 until MX).foreach(i => {
    arr(i)(0) = 1
    arr(i)(i) = 1
    (1 until i).foreach(j => arr(i)(j) = arr(i - 1)(j - 1) + arr(i - 1)(j))
  })

  private def lucas(n: Int, k: Int, p: Int): Int =
    if (k == 0) 1
    else arr(n % p)(k % p) * lucas(n / p, k / p, p) % p

  private def comb10(n: Int, k: Int): Int =
    lucas(n, k, 2) * 5 + lucas(n, k, 5) * 6

  def hasSameDigits(s: String): Boolean = {
    val n = s.length
    val ords = s.map(_.toInt)
    val sum = ords.zip(ords.tail).zipWithIndex.map { case ((x, y), i) => comb10(n - 2, i) * (x - y) }.sum
    sum % 10 == 0
  }
}
