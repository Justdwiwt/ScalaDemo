package leetCode

import scala.collection.mutable

object Solution_2295 {
  def arrayChange(nums: Array[Int], operations: Array[Array[Int]]): Array[Int] = {
    val m = mutable.Map.empty[Int, Int]
    nums.zipWithIndex.foreach { case (num, i) => m(num) = i }
    operations
      .withFilter { case Array(_, _) => true; case _ => false }
      .foreach { case Array(u, v) =>
        if (m.contains(u)) {
          m(v) = m(u)
          m.remove(u)
        }
      }

    m.toSeq.sortBy(_._2).map(_._1).toArray
  }
}
