package leetCode._1200

object Solution_1181 {
  def beforeAndAfterPuzzles(phrases: Array[String]): List[String] = {
    if (phrases.length == 1) return Nil

    phrases.indices.flatMap(i => {
      val suffix = phrases(i).substring(phrases(i).lastIndexOf(" ") + 1)
      phrases.indices.filter(_ != i).flatMap(j => {
        val split = phrases(j).split(" ")
        if (split.head == suffix) Some(phrases(i) + phrases(j).substring(suffix.length)) else None
      })
    }).toSet.toList.sorted
  }
}
