package leetCode

import java.util.PriorityQueue

object Offer_41 {

  class MedianFinder() {

    /** initialize your data structure here. */

    var mx = new PriorityQueue[Int]((a: Int, b: Int) => b - a)
    var mn = new PriorityQueue[Int]()

    def addNum(num: Int) {
      mx.add(num)
      mn.add(mx.poll())
      if (mx.size() + 1 < mn.size()) mx.add(mn.poll())
    }

    def findMedian(): Double = {
      if (mn.size() > mx.size()) return mn.peek()
      (mx.peek() + mn.peek()) / 2.0
    }

  }

}
