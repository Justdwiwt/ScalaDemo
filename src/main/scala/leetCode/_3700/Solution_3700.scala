package leetCode._3700

object Solution_3700 {
  private val M = 1000000007L

  def zigZagArrays(n: Int, l: Int, r: Int): Int = {
    val k = r - l + 1

    val m: Vector[Vector[Long]] =
      Vector.tabulate(k, k)((i, j) => if (j < k - 1 - i) 1L else 0L)

    val f1: Vector[Vector[Long]] =
      Vector.fill(k)(Vector(1L))

    val fn = powMul(m, n - 1, f1)

    val ans = fn.map(_.head).sum % M
    ((ans * 2) % M).toInt
  }

  @scala.annotation.tailrec
  private def powMul(
                      a: Vector[Vector[Long]],
                      n: Int,
                      f: Vector[Vector[Long]]
                    ): Vector[Vector[Long]] =
    if (n == 0) f
    else if ((n & 1) == 1)
      powMul(mul(a, a), n >> 1, mul(a, f))
    else
      powMul(mul(a, a), n >> 1, f)

  private def mul(
                   a: Vector[Vector[Long]],
                   b: Vector[Vector[Long]]
                 ): Vector[Vector[Long]] =
    Vector.tabulate(a.length, b.head.length)((i, j) => {
      a(i).indices.foldLeft(0L) { (s, k) =>
        if (a(i)(k) == 0) s
        else (s + a(i)(k) * b(k)(j)) % M
      }
    })
}
