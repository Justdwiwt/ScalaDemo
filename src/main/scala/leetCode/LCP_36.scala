package leetCode

import scala.collection.mutable

object LCP_36 {
  def maxGroupNumber(tiles: Array[Int]): Int = {
    var num, tol = 0
    val m = mutable.HashMap.empty[Int, Int]
    tiles.foreach(t => m += t -> (m.getOrElse(t, 0) + 1))
    var dp = Array.fill(5, 5)(0)
    val arr = tiles.distinct.sorted
    arr.foreach(title => {
      val tmp = Array.fill(5, 5)(0)
      val cur = m.getOrElse(title, 0)
      val pre = m.getOrElse(title - 1, 0)
      val first = m.getOrElse(title - 2, 0)
      (0 until 5.min(pre + 1)).foreach(row => {
        (0 until 5.min(cur + 1)).foreach(col => {
          num = Int.MinValue
          tol = cur - col
          (0 until 5.min(first + 1)).foreach(r => {
            (0 until (5 - row).min(pre + 1 - row)).foreach(c => {
              val s = 2.min(tol).min(r.min(c))
              (0 to s).foreach(i => num = num.max(i + (r - i) / 3 + (c - i) / 3 + (tol - i) / 3 + dp(r)(c + row)))
            })
          })
          tmp(row)(col) = num
        })
      })
      dp = tmp
    })
    dp.head.head
  }
}
