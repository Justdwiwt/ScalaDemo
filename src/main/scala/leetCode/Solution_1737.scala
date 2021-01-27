package leetCode

object Solution_1737 {
  def minCharacters(a: String, b: String): Int = {
    val A = freq(a)
    val B = freq(b)

    val pSumsA = prefix(A)
    val pSumsB = prefix(B)

    0.until(26).iterator.map(i => {
      def f(pSums1: Array[Int], pSums2: Array[Int]): Int =
        if (i == 25) Int.MaxValue
        else rangeSum(pSums1, i + 1, 25) + rangeSum(pSums2, 0, i)

      val opsAltB = f(pSumsA, pSumsB)
      val opsBltA = f(pSumsB, pSumsA)
      val opsAllSame = pSumsA.last - A(i) + pSumsB.last - B(i)
      Array(opsAltB, opsBltA, opsAllSame).min
    }).min
  }

  def prefix(arr: Array[Int]): Array[Int] = {
    val res = Array.tabulate(arr.length + 1)(i => if (i == 0) 0 else arr(i - 1))
    1.until(res.length).foreach(i => res(i) += res(i - 1))
    res
  }

  def rangeSum(arr: Array[Int], i: Int, j: Int): Int =
    arr(j + 1) - arr(i)

  def freq(s: String): Array[Int] = {
    val res = Array.fill(26)(0)
    s.foreach(c => res(c - 'a') += 1)
    res
  }
}
