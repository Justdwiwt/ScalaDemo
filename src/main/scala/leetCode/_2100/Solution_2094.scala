package leetCode._2100

import scala.collection.mutable

object Solution_2094 {
  def findEvenNumbers(digits: Array[Int]): Array[Int] = {
    val st = mutable.HashSet.empty[Int]
    val sorted = digits.sortWith(_ < _)
    digits.indices.withFilter(sorted(_) != 0).foreach(i =>
      digits.indices.withFilter(i != _).foreach(j =>
        digits.indices.withFilter(k => k != i && k != j && sorted(k) % 2 == 0).foreach(k =>
          st += (100 * sorted(i) + 10 * sorted(j) + sorted(k)))))
    st.toArray.sortWith(_ < _)
  }
}
