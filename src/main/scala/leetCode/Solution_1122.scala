package leetCode

import scala.collection.mutable

object Solution_1122 {
  def relativeSortArray(arr1: Array[Int], arr2: Array[Int]): Array[Int] = {
    val m1 = mutable.HashMap[Int, Int]()
    val m2 = mutable.HashMap[Int, Int]()
    arr2.foreach(x => m1.put(x, 0))
    arr1.foreach(x => if (m1.contains(x)) m1(x) += 1 else m2.put(x, 1 + m2.getOrElse(x, 0)))
    var list = List.empty[Int]
    arr2.foreach(x => list = if (m1.contains(x)) list ++ List.fill(m1(x))(x) else list)
    (list ++ arr1.filterNot(x => m1.contains(x)).toList.sorted).toArray
  }
}
