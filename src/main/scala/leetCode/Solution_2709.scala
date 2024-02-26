package leetCode

import scala.math.sqrt

object Solution_2709 {
  private object Math {
    def generatePrimesUpToN(n: Int): Array[Int] = {
      val sieve = Array.fill(n + 1)(true)

      sieve(0) = false
      sieve(1) = false

      (2 to sqrt(n).toInt)
        .filter(sieve)
        .foreach(i => (i * i to n by i).foreach(sieve(_) = false))

      (2 to n).filter(sieve)

    }.toArray
  }

  import DisjointSets.Index
  import Math.generatePrimesUpToN

  trait DisjointSets {
    def union(a: Index, b: Index): Unit

    def sameSets(a: Index, b: Index): Boolean

    def differentSets(a: Index, b: Index): Boolean

    def toSets: Set[Set[Index]]

    def reset(x: Index): Unit

    def get(x: Index): Seq[Index]
  }

  private class DisjointSetsImpl(n: Int) extends DisjointSets {
    private val parents: Array[Index] = (0 until n).toArray
    private val sizes: Array[Int] = Array.fill(n)(1)

    def union(a: Index, b: Index): Unit = {
      val x = find(a)
      val y = find(b)
      if (x != y) {
        val (a, b) = if (sizes(x) < sizes(y)) (y, x) else (x, y)
        parents(b) = a
        sizes(a) = sizes(a) + sizes(b)
      }
    }

    private def find(value: Index): Index = {
      var x = value
      var root = x
      while (parents(root) != root)
        root = parents(root)
      while (parents(x) != root) {
        val parent = parents(root)
        parents(x) = root
        x = parent
      }

      root
    }

    override def get(x: Index): Seq[Index] = parents
      .indices
      .filter(find(_) == find(x))

    override def sameSets(a: Index, b: Index): Boolean =
      find(a) == find(b)

    override def differentSets(a: Index, b: Index): Boolean =
      !sameSets(a, b)

    override def toSets: Set[Set[Index]] = parents
      .indices
      .groupBy(find)
      .values
      .map(_.toSet)
      .toSet

    override def reset(x: Index): Unit = {
      parents(x) = x
      sizes(x) = 1
    }
  }

  object DisjointSets {
    type Index = Int

    def make(n: Int): DisjointSets = new DisjointSetsImpl(n)
  }

  private val MaxN = 100000

  def canTraverseAllPairs(numbers: Array[Int]): Boolean = {
    if (numbers.contains(1)) return numbers.length == 1

    val nums = numbers.distinct
    val n = nums.length
    val primes = generatePrimesUpToN(MaxN)

    val primeUsage: Array[List[Int]] = Array.fill(primes.length)(Nil)

    nums
      .zipWithIndex
      .foreach { case (n, idx) => primes
        .indices
        .filter(n % primes(_) == 0)
        .foreach { primeIndex => primeUsage(primeIndex) = idx :: primeUsage(primeIndex) }
      }

    val disjointSets = DisjointSets.make(n)

    primeUsage.foreach {
      case head :: tail => tail.foreach(disjointSets.union(head, _))
      case _ =>
    }

    nums
      .indices
      .dropRight(1)
      .forall(i => (i until n).forall(disjointSets.sameSets(i, _)))

  }
}
