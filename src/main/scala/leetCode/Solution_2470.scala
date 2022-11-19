package leetCode

import java.math.BigInteger

object Solution_2470 {
  def subarrayLCM(nums: Array[Int], k: Int): Int = {
    var res = 0
    nums.indices.foreach(i => {
      var lcm = BigInteger.ONE
      (i until nums.length).foreach(j => {
        lcm = lcm.multiply(BigInteger.valueOf(nums(j))).divide(lcm.gcd(BigInteger.valueOf(nums(j))))
        if (lcm.doubleValue == k) res += 1
      })
    })
    res
  }
}
