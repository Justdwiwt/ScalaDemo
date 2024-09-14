package leetCode._3300

object Solution_3284 {
  def getSum(nums: Array[Int]): Int = {
    val M = BigInt(1000000007)

    val (res, _, _, _) = nums.foldLeft((BigInt(0), BigInt(0), 0, BigInt(-1))) {
      case ((r, sm, cnt, last), i) =>
        val bigI = BigInt(i)
        val (newSm, newCnt) =
          if (bigI == last + 1) {
            if (cnt >= 0) (sm + bigI * (cnt + 2), cnt + 1)
            else (bigI * 2 + last, 1)
          } else if (bigI == last - 1) {
            if (cnt <= 0) (sm - bigI * (cnt - 2), cnt - 1)
            else (bigI * 2 + last, -1)
          } else (bigI, 0)
        val newRes = (r + newSm) % M
        (newRes, newSm % M, newCnt, bigI)
    }

    res.toInt
  }
}
