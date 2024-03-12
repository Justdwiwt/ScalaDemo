package leetCode._2400

object Solution_2342 {
  def maximumSum(nums: Array[Int]): Int = {
    @scala.annotation.tailrec
    def f(n: Int, s: Int): Int =
      if (n == 0) s
      else f(n / 10, s + n % 10)

    nums./:(-1, Map.empty[Int, Int]) {
      case ((mxSum, mxNum), n) =>
        val sum = f(n, 0)
        mxNum.get(sum) match {
          case None => (mxSum, mxNum.updated(sum, n))
          case Some(max) => (mxSum.max(max + n), mxNum.updated(sum, max.max(n)))
        }
    }._1
  }
}
