package leetCode._3400

object Solution_3347 {
  def maxFrequency(nums: Array[Int], k: Int, numOperations: Int): Int = {
    def addToMap(map: collection.mutable.Map[Int, Int], key: Int, value: Int): Unit =
      map(key) = map.getOrElse(key, 0) + value

    val cnt = collection.mutable.Map.empty[Int, Int]
    val diff = collection.mutable.Map.empty[Int, Int].withDefaultValue(0)
    nums.foreach(x => {
      addToMap(cnt, x, 1)
      addToMap(diff, x, 0)
      addToMap(diff, x - k, 1)
      addToMap(diff, x + k + 1, -1)
    })

    val sortedDiff = diff.toSeq.sortBy(_._1)
    val res = sortedDiff.foldLeft((0, 0)) { case ((sum_d, maxFreq), (x, d)) =>
      val newSumD = sum_d + d
      val newMaxFreq = maxFreq.max(newSumD.min(cnt.getOrElse(x, 0) + numOperations))
      (newSumD, newMaxFreq)
    }._2
    res
  }
}
