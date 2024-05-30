package leetCode._3200

object Solution_3167 {
  def betterCompression(compressed: String): String = {
    val arr = Array.fill(26)(0)
    var l = 0
    val n = compressed.length

    while (l < n) {
      val cur = compressed(l).toInt - 97
      var r = l + 1
      while (r < n && compressed(r).isDigit) r += 1
      arr(cur) += compressed.substring(l + 1, r).toInt
      l = r
    }

    arr
      .zipWithIndex
      .filter { case (count, _) => count > 0 }
      .map { case (count, idx) => (idx + 97).toChar.toString + count }
      .mkString("")
  }
}
