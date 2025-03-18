package leetCode._3500

import scala.math.BigInt.int2bigInt

object Solution_3479 {
  def numOfUnplacedFruits(fruits: Array[Int], baskets: Array[Int]): Int = {
    class SegmentTree(n: Int) {
      private val size = 1 << (n.bitLength + 1)
      private val maxTree = Array.fill(size)(0)

      def build(a: Array[Int], idx: Int, l: Int, r: Int): Unit =
        if (l == r) maxTree(idx) = a(l)
        else {
          val m = (l + r) / 2
          build(a, idx * 2, l, m)
          build(a, idx * 2 + 1, m + 1, r)
          maxTree(idx) = Math.max(maxTree(idx * 2), maxTree(idx * 2 + 1))
        }

      def findFirstAndUpdate(idx: Int, l: Int, r: Int, x: Int): Boolean = {
        if (maxTree(idx) < x) return false
        if (l == r) {
          maxTree(idx) = -1
          return true
        }
        val m = (l + r) / 2
        val found = if (findFirstAndUpdate(idx * 2, l, m, x)) true
        else findFirstAndUpdate(idx * 2 + 1, m + 1, r, x)
        maxTree(idx) = Math.max(maxTree(idx * 2), maxTree(idx * 2 + 1))
        found
      }
    }

    val n = baskets.length
    val tree = new SegmentTree(n)
    tree.build(baskets, 1, 0, n - 1)

    fruits.count(!tree.findFirstAndUpdate(1, 0, n - 1, _))
  }
}
