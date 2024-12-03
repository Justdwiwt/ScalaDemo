package leetCode._3400

object Solution_3366 {
  def minArraySum(nums: Array[Int], k: Int, op1: Int, op2: Int): Int = {
    val arr = Array.fill(op1 + 1, op2 + 1)(0)
    nums.foldLeft(arr)((dp, x) => {
      (op1 to 0 by -1).flatMap(p => {
        (op2 to 0 by -1).map(q => {
          var res = dp(p)(q) + x
          if (p > 0) res = res.min(dp(p - 1)(q) + (x + 1) / 2)
          if (q > 0 && x >= k) {
            res = res.min(dp(p)(q - 1) + x - k)
            if (p > 0) {
              val y = if ((x + 1) / 2 >= k) (x + 1) / 2 - k else (x - k + 1) / 2
              res = res.min(dp(p - 1)(q - 1) + y)
            }
          }
          dp(p)(q) = res
          dp
        })
      }).head
    })
    arr(op1)(op2)
  }
}
