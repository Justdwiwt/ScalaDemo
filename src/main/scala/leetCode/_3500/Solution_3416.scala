package leetCode._3500

object Solution_3416 {
  val M = 1000000007

  def subsequencesWithMiddleMode(nums: Array[Int]): Int = {
    val n = nums.length
    val sorted = nums.sorted.distinct
    val m = sorted.length
    val idxMap = sorted.zipWithIndex.toMap
    val numsIdx = nums.map(idxMap)

    val pre = Array.fill(m)(0L)
    val suf = Array.fill(m)(0L)

    numsIdx.foreach(suf(_) += 1)

    var res = 0L
    var leftSum, rightSum, preMulSuf, prePreMulSuf, preMulSufSuf = 0L

    sorted.indices.foreach(i => rightSum = (rightSum + suf(i) * (suf(i) - 1) / 2) % M)

    nums.indices.foreach(i => {
      val x = numsIdx(i)
      rightSum = (rightSum - (suf(x) - 1) % M + M) % M
      preMulSuf = (preMulSuf - pre(x) % M + M) % M
      prePreMulSuf = (prePreMulSuf - pre(x) * pre(x) % M + M) % M
      preMulSufSuf = (preMulSufSuf - pre(x) * (2 * suf(x) - 1) % M + M) % M
      suf(x) -= 1

      val leftDouble = pre(x) * (pre(x) - 1) / 2 % M
      val rightDouble = suf(x) * (suf(x) - 1) / 2 % M
      val leftOne = pre(x) * i - pre(x) * pre(x)
      val rightOne = suf(x) * (n - i - 1) - suf(x) * suf(x)
      val leftZero = (1L * i * (i - 1) / 2 - leftDouble % M - leftOne % M + M) % M
      val rightZero = (1L * (n - i - 1) * (n - i - 2) / 2 - rightDouble % M - rightOne % M + M) % M

      val left = (leftZero - leftSum % M + leftDouble + M) % M
      val right = (rightZero - rightSum % M + rightDouble + M) % M

      res = (res + leftDouble * rightDouble) % M
      res = (res + leftDouble * rightOne + leftOne * rightDouble) % M
      res = (res + leftDouble * rightZero + leftZero * rightDouble + leftOne * rightOne) % M

      if (left * rightOne > 0) {
        res = (res + left * rightOne) % M
        val t = preMulSuf - pre(x) * suf(x)
        val s = prePreMulSuf - pre(x) * pre(x) * suf(x)
        val extra = suf(x) * (t * (i - pre(x)) % M - s % M + M) % M
        res = (res - extra % M + M) % M
      }

      if (right * leftOne > 0) {
        res = (res + right * leftOne) % M
        val t = preMulSuf - pre(x) * suf(x)
        val s = preMulSufSuf - pre(x) * suf(x) * suf(x)
        val extra = pre(x) * (t * (n - i - 1 - suf(x)) % M - s % M + M) % M
        res = (res - extra % M + M) % M
      }

      leftSum = (leftSum + pre(x)) % M
      preMulSuf = (preMulSuf + suf(x)) % M
      prePreMulSuf = (prePreMulSuf + (2 * pre(x) + 1) * suf(x) % M) % M
      preMulSufSuf = (preMulSufSuf + suf(x) * suf(x)) % M
      pre(x) += 1
    })

    res.toInt
  }
}
