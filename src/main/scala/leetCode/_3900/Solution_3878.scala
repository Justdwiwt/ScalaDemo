package leetCode._3900

object Solution_3878 {
  def countGoodSubarrays(nums: Array[Int]): Long = {
    var ans: Long = 0
    val lastSeen = collection.mutable.Map[Int, Int]()
    var currentOrs = List[(Int, Int)]()

    nums.indices.foreach(j => {
      val v = nums(j)
      lastSeen(v) = j

      var newOrs = List[(Int, Int)]()
      val tempPrev = currentOrs :+ (0, j)

      tempPrev.foreach { case (existingOr, startIdx) =>
        val combinedOr = existingOr | v
        if (newOrs.isEmpty || newOrs.last._1 != combinedOr)
          newOrs = newOrs :+ (combinedOr, startIdx)
      }

      currentOrs = newOrs

      currentOrs.indices.foreach(i => {
        val (orVal, startLimit) = currentOrs(i)
        val endLimit = if (i + 1 < currentOrs.length) currentOrs(i + 1)._2 - 1 else j
        lastSeen.get(orVal) match {
          case Some(pos) => if (pos >= startLimit) {
            val validStarts = Math.min(pos, endLimit) - startLimit + 1
            ans += Math.max(0, validStarts)
          }
          case None =>
        }

      })
    })

    ans
  }
}
