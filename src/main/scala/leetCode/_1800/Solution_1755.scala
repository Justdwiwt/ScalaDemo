package leetCode._1800

import scala.collection.Searching.search
import scala.collection.mutable

object Solution_1755 {
  def minAbsDifference(nums: Array[Int], goal: Int): Int = {
    var min = Long.MaxValue

    def genSum(i: Int = 0, e: Int = nums.length / 2, sum: Long = 0, set: mutable.Set[Long]): mutable.Set[Long] = {
      if (i == e) set += sum
      else {
        genSum(i + 1, e, sum + nums(i), set)
        genSum(i + 1, e, sum, set)
      }
      set
    }

    val set1 = genSum(0, nums.length / 2, 0, mutable.Set[Long]())
    val arr2 = genSum(nums.length / 2, nums.length, 0, mutable.Set[Long]()).toArray[Long].sorted

    object Bound extends Enumeration {
      type Bound = Value
      val Lower, Upper = Value
    }

    import Bound._

    def binSearch(t: Long, bound: Bound): Long = arr2.search(t) match {
      case i: collection.Searching.InsertionPoint => arr2((i.insertionPoint + (if (bound == Upper) 0 else -1)).min(arr2.length - 1).max(0))
      case f: collection.Searching.Found => arr2(f.insertionPoint)
    }

    set1.foreach(s => min = (s + binSearch(goal - s, Lower) - goal).abs.min((s + binSearch(goal - s, Upper) - goal).abs).min(min))
    min.toInt
  }
}
