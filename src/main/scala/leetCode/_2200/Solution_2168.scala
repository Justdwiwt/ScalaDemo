package leetCode._2200

object Solution_2168 {
  def equalDigitFrequency(s: String): Int = {
    val sum = Array.ofDim[Int](s.length + 1, 10)
    val res = collection.mutable.Set.empty[String]

    s.zipWithIndex.foreach { case (c, i) =>
      sum(i + 1) = sum(i).clone()
      sum(i + 1)(c - '0') += 1
      (0 to i).foreach(j => {
        var m = 0
        var check = true
        (0 until 10).foreach(k => {
          val diff = sum(i + 1)(k) - sum(j)(k)
          if (diff != 0) {
            if (m != 0 && m != diff) check = false
            m = diff
          }
        })
        if (check) res.add(s.substring(j, i + 1))
      })
    }
    res.size
  }
}
