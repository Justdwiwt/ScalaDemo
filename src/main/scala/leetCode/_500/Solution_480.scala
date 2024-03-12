package leetCode._500

import scala.collection.mutable

object Solution_480 {
  def medianSlidingWindow(nums: Array[Int], k: Int): Array[Double] = {
    val mxHeap = mutable.TreeSet.empty[Int](Ordering[(Int, Int)].on(x => (nums(x), x)))
    val mnHeap = mutable.TreeSet.empty[Int](Ordering[(Int, Int)].on((x: Int) => (nums(x), x)).reverse)
    nums.indices./:(List.empty[Double]) { case (acc, i) =>
      addNum(i, mxHeap, mnHeap)
      if (mxHeap.size + mnHeap.size == k) {
        val newAcc = acc :+ findMedian(nums, mxHeap, mnHeap)
        slide(acc.size, mxHeap, mnHeap)
        newAcc
      } else acc
    }.toArray
  }

  def addNum(num: Int, mx: mutable.TreeSet[Int], mn: mutable.TreeSet[Int]): Unit = {
    mx += num
    mn += mx.head
    mx -= mx.head
    if (mx.size < mn.size) {
      mx += mn.head
      mn -= mn.head
    }
  }

  def findMedian(nums: Array[Int], mx: mutable.TreeSet[Int], mn: mutable.TreeSet[Int]): Double =
    if (mn.size == mx.size) nums(mn.head) / 2.0 + nums(mx.head) / 2.0
    else nums(mx.head)

  def slide(move: Int, mx: mutable.TreeSet[Int], mn: mutable.TreeSet[Int]): Unit =
    if (!mx.remove(move)) mn.remove(move)
}
