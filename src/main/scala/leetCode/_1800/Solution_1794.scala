package leetCode._1800

object Solution_1794 {
  def countQuadruples(firstString: String, secondString: String): Int = {
    val arr = secondString.zipWithIndex.foldLeft(Map[Char, Int]())((acc, pair) => acc + (pair._1 -> (pair._2 + 1)))
    val min = firstString.indices.foldLeft(10000000)((minVal, i) => {
      val idx = arr.getOrElse(firstString(i), 0)
      if (idx != 0) {
        if (i - idx < minVal) i - idx else minVal
      } else minVal
    })
    firstString.indices.count(i => {
      val idx = arr.getOrElse(firstString(i), 0)
      idx != 0 && i - idx == min
    })
  }
}
