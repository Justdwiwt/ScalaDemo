package leetCode._1600

object Solution_1554 {
  // fixme: case 79/81 memory limit exceeded
  def differByOne(dict: Array[String]): Boolean =
    dict.head.indices.exists(i => {
      val modeFreq = dict.map(s => {
        val sb = new StringBuilder(s)
        sb.setCharAt(i, '*')
        sb.toString
      }).groupBy(identity).mapValues(_.length)
      modeFreq.values.max > 1
    })
}
