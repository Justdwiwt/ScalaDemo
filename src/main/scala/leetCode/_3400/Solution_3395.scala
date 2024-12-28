package leetCode._3400

import scala.collection.mutable

object Solution_3395 {
  def subsequencesWithMiddleMode(nums: Array[Int]): Int = {
    val n = nums.length
    val suf = mutable.Map.empty[Int, Int]
    val pre = mutable.Map.empty[Int, Int]
    nums.foreach(num => suf.update(num, suf.getOrElse(num, 0) + 1))

    @scala.annotation.tailrec
    def comb(n: Int, k: Int): BigInt =
      if (k < 0 || k > n) BigInt(0)
      else if (k == 0 || k == n) BigInt(1)
      else if (k > n / 2) comb(n, n - k)
      else {
        var res = BigInt(1)
        (1 to k).foreach(i => res = res * (n - i + 1) / i)
        res
      }

    var res = comb(n, 5)
    nums.zipWithIndex.dropRight(2).foreach { case (x, left) =>
      suf(x) -= 1
      if (left > 1) {
        val right = n - 1 - left
        val preX = pre.getOrElse(x, 0)
        val sufX = suf.getOrElse(x, 0)
        res -= comb(left - preX, 2) * comb(right - sufX, 2)
        suf.foreach { case (y, sufY) =>
          if (y == x) {}
          else {
            val preY = pre.getOrElse(y, 0)
            res -= comb(preY, 2) * sufX * (right - sufX)
            res -= comb(sufY, 2) * preX * (left - preX)
            res -= preY * sufY * preX * (right - sufX - sufY)
            res -= preY * sufY * sufX * (left - preX - preY)
          }
        }
      }
      pre.update(x, pre.getOrElse(x, 0) + 1)
    }
    (res % 1000000007).toInt
  }
}
