package leetCode._2600

import scala.collection.immutable.SortedSet

object Solution_2584 {
  lazy val primes: SortedSet[Int] = {
    val ps = (3 to 1000000 by 2).filter(BigInt(_).isProbablePrime(10))
    SortedSet(2) ++ ps
  }

  def findValidSplit(nums: Array[Int]): Int = {
    type ASet = Set[Int]
    val anEmptySet: ASet = Set.empty

    @scala.annotation.tailrec
    def f(n: Int, m: Int = 2, acc: ASet = anEmptySet): ASet =
      if (primes.contains(n)) acc + n
      else if (m * 2 > n) acc
      else if (n % m == 0) f(n / m, m, acc + m)
      else {
        val next = primes.dropWhile(_ <= m).head
        f(n, next, acc)
      }

    val fs: Vector[ASet] = nums.map(f(_)).toVector
    val pfx: Vector[ASet] = fs.scanLeft(anEmptySet)((a, b) => a ++ b)
    val sfx: Vector[ASet] = fs.reverse.scanLeft(anEmptySet)((a, b) => a ++ b).reverse

    pfx
      .zip(sfx)
      .slice(1, nums.length)
      .zipWithIndex
      .find { case ((a, b), _) => (a & b).isEmpty }
      .map(_._2)
      .getOrElse(-1)
  }
}
