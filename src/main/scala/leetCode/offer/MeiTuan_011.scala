package leetCode.offer

import java.util.Scanner

object MeiTuan_011 {
  def main(args: Array[String]): Unit = {
    val sc = new Scanner(System.in)
    var mx = 0L
    val nums = Array.fill(4)(0)
    (0 until 4).foreach(i => nums(i) = sc.nextInt())
    var prices = Array.fill(3, 2)(0L)
    (0 until 3).foreach(i => {
      prices(i)(0) = i
      prices(i)(1) = sc.nextInt()
    })
    prices = prices.sorted((o1: Array[Long], o2: Array[Long]) => {
      if (o1(1) == o2(1)) (o1.head - o2.head).toInt
      else (o2(1) - o1(1)).toInt
    })
    (0 until 3).foreach(i => {
      if (nums(3) >= nums(prices(i).head.toInt)) {
        mx += nums(prices(i).head.toInt) * prices(i)(1)
        nums(3) -= nums(prices(i).head.toInt)
      } else {
        mx += nums(3) * prices(i)(1)
        nums(3) = 0
      }
    })
    sc.close()
    println(mx)
  }
}
