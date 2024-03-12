package leetCode._1900

import scala.collection.mutable

object Solution_1865 {

  class FindSumPairs(_nums1: Array[Int], _nums2: Array[Int]) {

    val cnt: mutable.Map[Int, Int] = mutable.Map.empty[Int, Int].withDefaultValue(0)

    _nums2.foreach(num => cnt(num) += 1)

    def add(index: Int, `val`: Int) {
      cnt(_nums2(index)) -= 1
      cnt(_nums2(index) + `val`) += 1
      _nums2(index) += `val`
    }

    def count(tot: Int): Int = {
      var res = 0
      _nums1.foreach(num => res += cnt(tot - num))
      res
    }

  }

}
