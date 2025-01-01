package leetCode._3400

object Solution_3336 {
  val M: Int = 1000000007
  val MX: Int = 201

  private val lcms: Vector[Vector[Int]] = (1 until MX).toVector.map(i => (1 until MX).toVector.map(lcm(i, _)))

  private val pow2: Vector[Int] = (0 until MX).scanLeft(1)((acc, _) => (acc * 2) % M).toVector
  private val pow3: Vector[Int] = (0 until MX).scanLeft(1)((acc, _) => ((acc.toLong * 3) % M).toInt).toVector

  private val mu: Vector[Int] = {
    val mutableMu = Array.fill(MX)(0)
    mutableMu(1) = 1
    (1 until MX).foreach(i => (i * 2 until MX by i).foreach(mutableMu(_) -= mutableMu(i)))
    mutableMu.toVector
  }

  def subsequencePairCount(nums: Array[Int]): Int = {
    val m = nums.max

    val cnt: Vector[Int] = (1 to m).foldLeft(Vector.fill(m + 1)(0))((acc, i) => {
      nums.foldLeft(acc)((innerAcc, x) => if (x % i == 0) innerAcc.updated(i, innerAcc(i) + 1) else innerAcc)
    })

    val f: Vector[Vector[Int]] = (1 to m).toVector.map(g1 =>
      (1 to m).toVector.map(g2 => {
        val l = if (g1 < MX && g2 < MX) lcms(g1 - 1)(g2 - 1) else lcm(g1, g2)
        val c = if (l <= m) cnt(l) else 0
        val c1 = cnt(g1)
        val c2 = cnt(g2)
        (((pow3(c).toLong * pow2(c1 + c2 - 2 * c) - pow2(c1) - pow2(c2) + 1) % M).toInt + M) % M
      })
    )

    val res = (1 to m)
      .foldLeft(0L)((acc, i) => (1 to m / i)
        .foldLeft(acc)((innerAcc, j) => (1 to m / i)
          .foldLeft(innerAcc)((finalAcc, k) => finalAcc + mu(j).toLong * mu(k) * f(j * i - 1)(k * i - 1))))

    ((res % M + M) % M).toInt
  }

  @scala.annotation.tailrec
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a
    else gcd(b, a % b)

  private def lcm(a: Int, b: Int): Int =
    a / gcd(a, b) * b
}
