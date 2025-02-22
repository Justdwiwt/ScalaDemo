package leetCode._3500

object Solution_3458 {
  def maxSubstringLength(s: String, k: Int): Boolean = {
    val n = s.length
    val pos = s.zipWithIndex.groupBy(_._1).map { case (char, indices) => (char - 'a', indices.map(_._2).toList) }
    val vec = pos.flatMap { case (_, indices) =>
      var l = indices.head
      var r = indices.last
      var flag = true

      while (flag) {
        flag = false
        pos.foreach { case (_, otherIndices) =>
          val cnt = otherIndices.count(i => i >= l && i <= r)
          if (cnt > 0 && cnt < otherIndices.length) {
            l = l.min(otherIndices.head)
            r = r.max(otherIndices.last)
            flag = true
          }
        }
      }

      if (l > 0 || r < n - 1) Some((r, l)) else None
    }.toList

    val sortedVec = vec.sortBy(_._1)
    val (_, cnt) = sortedVec.foldLeft((-1, 0)) { case ((prevR, acc), (r, l)) =>
      if (l > prevR) (r, acc + 1) else (prevR, acc)
    }

    cnt >= k
  }
}
