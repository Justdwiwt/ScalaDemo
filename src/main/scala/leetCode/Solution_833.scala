package leetCode

object Solution_833 {
  def findReplaceString(S: String, indexes: Array[Int], sources: Array[String], targets: Array[String]): String = {
    val arr = Array.fill(S.length)(-1)
    val res = new StringBuilder
    indexes.indices.foreach(i => {
      val ix = indexes(i)
      if (S.substring(ix, ix + sources(i).length).equals(sources(i))) arr(ix) = i
    })
    var ix = 0
    while (ix < S.length) {
      if (arr(ix) >= 0) {
        res.append(targets(arr(ix)))
        ix += sources(arr(ix)).length
      } else {
        res.append(S(ix))
        ix += 1
      }
    }
    res.toString
  }
}
