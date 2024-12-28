package leetCode._2500

import scala.collection.mutable

object Solution_2459 {
  def sortArray(nums: Array[Int]): Int = {
    val n = nums.length
    if (n == 0) return 0
    val a = getMinCnt(nums, 0)
    val nums2 = nums.map(x => (x + n - 1) % n)
    val b = getMinCnt(nums2, n - 1)
    a.min(b)
  }

  private def getMinCnt(nums: Array[Int], dis: Int): Int = {
    var res = 0
    val visSet = mutable.HashSet.empty[Int]
    nums.indices.foreach(i => {
      var j = i
      if (j != nums(j) && !visSet.contains(j)) {
        val tmpVisSet = mutable.HashSet.empty[Int]
        while (!tmpVisSet.contains(j)) {
          tmpVisSet += j
          j = nums(j)
        }
        res += tmpVisSet.size + (if (tmpVisSet.contains(dis)) -1 else 1)
        visSet ++= tmpVisSet
      }
    })
    res
  }
}
