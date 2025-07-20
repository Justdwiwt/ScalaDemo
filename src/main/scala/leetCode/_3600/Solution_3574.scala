package leetCode._3600

object Solution_3574 {
  def maxGCDScore(nums: Array[Int], k: Int): Long = {

    def lowBit(x: Int): Int =
      x & -x

    @scala.annotation.tailrec
    def gcd(a: Int, b: Int): Int =
      if (b == 0) a else gcd(b, a % b)

    nums.indices.foldLeft(0L) { case (globalMax, i) =>
      val (_, _, _, _, localMax) = (i to 0 by -1).foldLeft((i, 0, Int.MaxValue, 0, 0L)) {
        case ((_, gPrev, lbMinPrev, lbCntPrev, localBest), j) =>
          val x = nums(j)
          val lb = lowBit(x)
          val lbMinNew =
            if (lb < lbMinPrev) lb
            else lbMinPrev

          val lbCntNew =
            if (lb < lbMinPrev) 1
            else if (lb == lbMinPrev) lbCntPrev + 1
            else lbCntPrev

          val gNew = gcd(gPrev, x)
          val newG = if (lbCntNew <= k) gNew * 2 else gNew
          val score = newG.toLong * (i - j + 1)

          (j, gNew, lbMinNew, lbCntNew, localBest.max(score))
      }

      globalMax.max(localMax)
    }
  }
}
