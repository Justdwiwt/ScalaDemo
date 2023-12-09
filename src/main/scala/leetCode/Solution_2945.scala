package leetCode

import scala.collection.Searching.{Found, InsertionPoint, search}

object Solution_2945 {
  def bisectLeft(a: Array[Long], key: Long): Int = {
    var id = a.search(key) match {
      case Found(idx) => idx
      case InsertionPoint(insertionPoint) => insertionPoint
    }
    while (id > 0 && a(id - 1) >= key) id -= 1
    id
  }

  //  def findMaximumLength(nums: Array[Int]): Int = {
  //    val n = nums.length
  //    val acc: Array[Long] = nums.scanLeft(0L)(_ + _)
  //    val pre = ArrayBuffer.fill(n + 2)(0)
  //    val dp = ArrayBuffer.fill(n + 1)(0)
  //    var i: Int = 0
  //    nums.zip(LazyList.iterate(1)(_ + 1)).foreach { case (_, j) =>
  //      i = i.max(pre(j))
  //      dp(j) = dp(i) + 1
  //      val k = bisectLeft(acc, acc(j) * 2 - acc(i))
  //      pre(k) = j
  //    }
  //    dp(n)
  //  }
}
