package leetCode._3400

object Solution_3337 {
  private val M: BigInt = BigInt(1000000007)
  private val N: Int = 26

  def lengthAfterTransformations(s: String, t: Int, nums: List[Int]): Int = {
    val arr = Array.fill(N, N)(BigInt(0))

    (0 until N).foreach(i => {
      val c = nums(i)
      (1 to c).foreach(j => arr(i)((i + j) % N) = 1)
    })

    val poweredMatrix = pow(arr, t)

    val cnt = Array.fill(N)(0)
    s.foreach(c => cnt(c - 'a') += 1)

    var res: BigInt = 0
    (0 until N).foreach(i => {
      val fti = poweredMatrix(i).sum
      res = (res + fti * cnt(i)) % M
    })

    res.toInt
  }

  private def pow(a: Array[Array[BigInt]], n: Int): Array[Array[BigInt]] = {
    var res = Array.fill(N, N)(BigInt(0))
    (0 until N).foreach(i => res(i)(i) = 1)

    var base = a
    var exp = n

    while (exp > 0) {
      if ((exp & 1) != 0) res = mul(res, base)
      base = mul(base, base)
      exp >>= 1
    }
    res
  }

  private def mul(a: Array[Array[BigInt]], b: Array[Array[BigInt]]): Array[Array[BigInt]] = {
    val res = Array.fill(N, N)(BigInt(0))
    (0 until N)
      .foreach(i => (0 until N)
        .foreach(j => (0 until N)
          .foreach(k => res(i)(j) = (res(i)(j) + (a(i)(k) * b(k)(j)) % M) % M)))
    res
  }
}
