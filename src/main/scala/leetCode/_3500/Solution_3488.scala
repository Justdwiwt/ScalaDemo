package leetCode._3500

import scala.collection.immutable.TreeSet

object Solution_3488 {
  def solveQueries(nums: Array[Int], queries: Array[Int]): List[Int] = {
    val n = nums.length

    val indices = nums.zipWithIndex.foldLeft(Map.empty[Int, TreeSet[Int]]) {
      case (acc, (num, idx)) =>
        acc.updated(num, acc.getOrElse(num, TreeSet.empty[Int]) + idx)
    }

    val updatedIndices = indices.mapValues(p => p + (p.last - n) + (p.head + n))

    queries.toList.map(i => {
      val p = updatedIndices(nums(i))
      if (p.size == 3) -1
      else {
        val jOpt = p.rangeImpl(None, Some(i)).lastOption
        val kOpt = p.rangeImpl(Some(i + 1), None).headOption
        (jOpt, kOpt) match {
          case (Some(j), Some(k)) => (i - j).min(k - i)
          case (Some(j), None) => i - j
          case (None, Some(k)) => k - i
          case _ => -1
        }
      }
    })
  }
}
