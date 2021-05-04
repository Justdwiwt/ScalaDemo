package leetCode

object Solution_833 {
  def findReplaceString(S: String, indexes: Array[Int], sources: Array[String], targets: Array[String]): String = {
    var res = S
    indexes.indices.map(i => Tuple2(indexes(i), i)).sortBy(_._1).reverse.foreach(tup => {
      val s = sources(tup._2)
      val t = targets(tup._2)
      if (res.substring(tup._1, tup._1 + s.length).equals(s)) res = res.substring(0, tup._1) + t + res.substring(tup._1 + s.length)
    })
    res
  }
}
