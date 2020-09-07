package leetCode

import scala.collection.immutable.HashSet

object Solution_347 {
  def topKFrequent(nums: Array[Int], k: Int): Array[Int] = {
    val (_, topK: HashSet[Int]) = nums.foldLeft(Map.empty[Int, Int], HashSet.empty[Int])((returnValue, current) => {
      val (frequency: Map[Int, Int], topK: HashSet[Int]) = returnValue
      val cnt = frequency.getOrElse(current, 0) + 1
      val updated = frequency + (current -> cnt)

      if (!topK.contains(current) && topK.size == k) {
        topK.collect({ case key if updated(key) < cnt => key -> updated(key) }) match {
          case list if list.isEmpty => (updated, topK)
          case list => (updated, topK - list.minBy(_._2)._1 + current)
        }
      } else (updated, topK + current)
    })

    topK.toArray
  }
}
