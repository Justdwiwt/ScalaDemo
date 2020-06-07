package leetCode

import scala.collection.mutable.ListBuffer

object Solution_1389 {
  def createTargetArray(nums: Array[Int], index: Array[Int]): Array[Int] = {
    val res = ListBuffer[Int]()
    index.indices.foreach(i => res.insert(index(i), nums(i)))
    res.toArray
  }
}
