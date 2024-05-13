package leetCode._3200

import scala.collection.mutable

object Solution_3144 {
  def minimumSubstringsInPartition(s: String): Int = {
    val dp = new Array[Int](s.length + 1)
    (1 to s.length).foreach(i => {
      var minPartitions = i
      val counts = mutable.HashMap.empty[Char, Int]
      var maxCount = 0
      var maxCountCharacters = 0
      (i - 1 to 0 by -1).foreach(j => {
        val c = s(j)
        counts(c) = counts.getOrElse(c, 0) + 1
        val count = counts(c)
        if (count == maxCount) maxCountCharacters += 1
        else if (count > maxCount) {
          maxCount = count
          maxCountCharacters = 1
        }
        if (maxCount * maxCountCharacters == i - j) minPartitions = minPartitions.min(dp(j) + 1)
      })
      dp(i) = minPartitions
    })
    dp(s.length)
  }
}
