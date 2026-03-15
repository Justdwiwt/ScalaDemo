package leetCode._3900

object Solution_3850 {
  def countSequences(nums: Array[Int], k: Long): Int = {

    val memo = collection.mutable.Map[(Int, BigInt, BigInt), Int]()

    @scala.annotation.tailrec
    def gcd(a: BigInt, b: BigInt): BigInt =
      if (b == 0) a.abs else gcd(b, a % b)

    def norm(a: BigInt, b: BigInt): (BigInt, BigInt) = {
      val g = gcd(a, b)
      val na = a / g
      val nb = b / g
      if (nb < 0) (-na, -nb) else (na, nb)
    }

    def dfs(i: Int, num: BigInt, den: BigInt): Int = {
      val (n, d) = norm(num, den)

      memo.getOrElseUpdate((i, n, d), {
        if (i < 0) {
          if (n == d) 1 else 0
        } else {
          val x = nums(i)

          dfs(i - 1, n * x, d) +
            dfs(i - 1, n, d * x) +
            dfs(i - 1, n, d)
        }
      })
    }

    dfs(nums.length - 1, BigInt(1), BigInt(k))
  }
}
