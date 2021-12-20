package leetCode

import scala.collection.mutable

object Solution_2100 {
  def goodDaysToRobBank(security: Array[Int], time: Int): List[Int] = {
    def f(arr: Array[(Int, Int)]): mutable.Set[Int] = {
      var start = 0
      val res = mutable.Set.empty[Int]
      if (time == 0) res += arr.head._2
      arr.indices.drop(1).foreach(i => {
        if (arr(i)._1 > arr(i - 1)._1) start = i
        if (i - start >= time) res += arr(i)._2
      })
      res
    }

    f(security.zipWithIndex).intersect(f(security.zipWithIndex.reverse)).toList.sorted
  }
}
