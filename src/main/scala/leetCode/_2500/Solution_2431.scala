package leetCode._2500

import scala.collection.mutable

object Solution_2431 {
  def maxTastiness(price: Array[Int], tastiness: Array[Int], maxAmount: Int, maxCoupons: Int): Int = {
    val n = price.length

    def dfs(i: Int, money: Int, coupon: Int, memo: mutable.Map[(Int, Int, Int), Int]): Int = {
      if (i == n) 0
      else if (memo.contains((i, money, coupon))) memo((i, money, coupon))
      else {
        val res1 = if (money >= price(i)) tastiness(i) + dfs(i + 1, money - price(i), coupon, memo) else 0
        val res2 = if (money >= price(i) / 2 && coupon > 0) tastiness(i) + dfs(i + 1, money - price(i) / 2, coupon - 1, memo) else 0
        val res3 = dfs(i + 1, money, coupon, memo)
        val res = res1.max(res2.max(res3))
        memo.update((i, money, coupon), res)
        res
      }
    }

    val m = mutable.Map.empty[(Int, Int, Int), Int]
    dfs(0, maxAmount, maxCoupons, m)
  }
}
