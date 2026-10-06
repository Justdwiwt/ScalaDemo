package leetCode._4100

object Solution_4011 {
  def countRatioSubarrays(nums: Array[Int], a: Int, b: Int): Int = {
    val prefix = nums.scanLeft(0L) {
      case (sum, x) => sum + (if (x % 2 == 1) a else -b)
    }

    def mergeCount(xs: Array[Long]): (Int, Array[Long]) = {
      if (xs.length <= 1) (0, xs)
      else {
        val (left, right) = xs.splitAt(xs.length / 2)
        val (lc, ls) = mergeCount(left)
        val (rc, rs) = mergeCount(right)

        val (_, _, cnt, merged) = xs.indices.foldLeft((0, 0, lc + rc, Array.empty[Long])) {
          case ((l, r, cnt, res), _) =>
            if (l < ls.length && (r == rs.length || ls(l) <= rs(r)))
              (l + 1, r, cnt, res :+ ls(l))
            else
              (l, r + 1, cnt + l, res :+ rs(r))
        }

        (cnt, merged)
      }
    }

    mergeCount(prefix)._1
  }
}
