package leetCode._1600

object Solution_1520 {
  def maxNumOfSubstrings(s: String): List[String] = {
    val lastTime = Array.fill(26)(-1)
    val firstTime = Array.fill(26)(-1)

    s.indices.foreach { i =>
      val idx = s(i) - 'a'
      if (firstTime(idx) == -1) firstTime(idx) = i
      lastTime(idx) = i
    }

    val sorted = lastTime.indices.collect { case i if lastTime(i) != -1 => lastTime(i) }.sorted

    sorted.foldLeft((List[String](), -1)) { case ((res, lastLoc), idx) =>
      val c = s(idx) - 'a'
      var pre = firstTime(c)
      var k = idx
      var valid = true

      while (k > pre && valid)
        if (lastTime(s(k) - 'a') > idx || k <= lastLoc)
          valid = false
        else {
          pre = pre.min(firstTime(s(k) - 'a'))
          k -= 1
        }

      if (k == pre && valid) (res :+ s.substring(pre, idx + 1), idx) else (res, lastLoc)
    }._1
  }
}
