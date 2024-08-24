package leetCode._3300

object Solution_3258 {
  def countKConstraintSubstrings(s: String, k: Int): Int = {
    @scala.annotation.tailrec
    def f(s: String, k: Int, left: Int, res: Int, cnt: (Int, Int), i: Int): Int =
      if (i == s.length) res
      else {
        val (zeros, ones) = cnt
        val newCnt = if ((s(i).toInt & 1) == 0) (zeros + 1, ones) else (zeros, ones + 1)

        val (updatedLeft, finalCnt) =
          if (newCnt._1 > k || newCnt._2 > k) {
            var tempLeft = left
            var tempCnt = newCnt
            while (tempCnt._1 > k && tempCnt._2 > k) {
              val leftChar = s(tempLeft).toInt & 1
              tempCnt = if (leftChar == 0) (tempCnt._1 - 1, tempCnt._2) else (tempCnt._1, tempCnt._2 - 1)
              tempLeft += 1
            }
            (tempLeft, tempCnt)
          } else (left, newCnt)

        f(s, k, updatedLeft, res + i - updatedLeft + 1, finalCnt, i + 1)
      }

    f(s, k, 0, 0, (0, 0), 0)
  }
}
