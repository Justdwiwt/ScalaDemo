package leetCode._2000

import leetCode.Common.sieveOfEratosthenes
import leetCode.UnionFind

import scala.collection.mutable

object Solution_1998 {
  def gcdSort(nums: Array[Int]): Boolean = {
    val spf = sieveOfEratosthenes(nums.max + 1)
    val uf = new UnionFind[Int]
    nums.foreach(n => primeFactors(n, spf).foreach(uf.union(n, _)))
    nums.zip(nums.sorted).forall { case (x, y) => uf.find(x) == uf.find(y) }
  }

  private def primeFactors(n: Int, spf: Seq[Int]): Seq[Int] = {
    val factors = mutable.ListBuffer.empty[Int]
    var num = n
    while (num > 1) {
      factors.append(spf(num))
      num /= spf(num)
    }
    factors
  }
}
