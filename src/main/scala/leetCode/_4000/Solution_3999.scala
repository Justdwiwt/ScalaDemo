package leetCode._4000

object Solution_3999 {
  def minimumGroups(words: Array[String]): Int = {
    def smallestRepresentation(s: String): String = {
      val n = s.length
      val str = s + s

      var i = 0
      var j = 1

      while (j < n) {
        var k = 0

        while (k < n && str(i + k) == str(j + k))
          k += 1

        if (k >= n) j = n
        else if (str(i + k) < str(j + k)) j += k + 1
        else {
          val oldI = i
          i = j
          j = j.max(oldI + k) + 1
        }
      }

      str.substring(i, i + n)
    }

    words.map { word =>
      val even = word
        .indices
        .collect { case i if i % 2 == 0 => word(i) }
        .mkString

      val odd = word
        .indices
        .collect { case i if i % 2 == 1 => word(i) }
        .mkString

      smallestRepresentation(even) + smallestRepresentation(odd)
    }.toSet.size
  }
}
