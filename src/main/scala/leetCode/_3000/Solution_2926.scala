package leetCode._3000

import scala.collection.mutable

object Solution_2926 {
  def maxBalancedSubsequenceSum(nums: Array[Int]): Long = {
    val map = mutable.TreeMap.empty[Int, Long]
    var max = nums.head.toLong

    nums.foreach(num => max = num.toLong.max(max))

    nums.indices.foreach(i => if (nums(i) < 0) () else {
      val entry = map.to(nums(i) - i).lastOption
      if (entry.isDefined) {
        map(nums(i) - i) = entry.get._2 + nums(i)
        max = max.max(entry.get._2 + nums(i))
      } else {
        map(nums(i) - i) = nums(i).toLong
        max = max.max(nums(i).toLong)
      }
      var node = map.from(nums(i) - i + 1).headOption
      while (node.isDefined && node.get._2 <= map(nums(i) - i)) {
        map.remove(node.get._1)
        node = map.from(nums(i) - i + 1).headOption
      }
    })
    max
  }
}
