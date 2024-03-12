package leetCode._1200

import scala.collection.mutable

object Solution_1129 {
  def shortestAlternatingPaths(n: Int, c1: Array[Array[Int]], c2: Array[Array[Int]]): Array[Int] = {
    val arr1 = Array.fill(n)(10000)
    val arr2 = Array.fill(n)(10000)
    arr1(0) = 0
    arr2(0) = 0
    val m1 = mutable.HashMap[Int, List[Int]]()
    val m2 = mutable.HashMap[Int, List[Int]]()
    c1.foreach({ case Array(x, y) => m1 += x -> (y :: m1.getOrElse(x, Nil)) })
    c2.foreach({ case Array(x, y) => m2 += x -> (y :: m2.getOrElse(x, Nil)) })
    var i = 0
    while (arr1.filterNot(_ == 10000).max.max(arr2.filterNot(_ == 10000).max) >= i) {
      (0 until n)
        .withFilter(k => m2.keySet.contains(k))
        .withFilter(k => arr1(k) == i)
        .foreach(k => m2(k).foreach(y => arr2(y) = arr2(y).min(i + 1)))
      (0 until n)
        .withFilter(k => m1.keySet.contains(k))
        .withFilter(k => arr2(k) == i)
        .foreach(k => m1(k).foreach(y => arr1(y) = arr1(y).min(i + 1)))
      i += 1
    }
    arr1.zip(arr2).map({ case (x, y) => x.min(y) }).map({ x => if (x == 10000) -1 else x })
  }
}
