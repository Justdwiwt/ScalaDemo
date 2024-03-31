package leetCode._1000

import leetCode.UnionFind

import scala.collection.mutable

object Solution_952 {
  def largestComponentSize(nums: Array[Int]): Int = {
    val uf = new UnionFind[Int]
    val m = mutable.Map.empty[Int, mutable.ListBuffer[Int]]
    nums.foreach(n => primeSet(n).foreach(m.getOrElseUpdate(_, mutable.ListBuffer.empty).append(n)))
    m.values.foreach(_.reduce(uf.union))
    nums.map(uf.find).groupBy(identity).values.map(_.length).max
  }

  private def primeSet(n: Int): Set[Int] = (2 to math.sqrt(n).toInt)
    .collectFirst { case i if n % i == 0 => primeSet(n / i) + i }
    .getOrElse(Set(n))
}
