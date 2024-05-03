package leetCode._300

object Solution_244 {
  class WordDistance(wordsDict: Array[String]) {
    private val mapper: Map[String, List[Int]] =
      wordsDict.zipWithIndex.groupBy(_._1).mapValues(_.map(_._2).toList)

    def shortest(word1: String, word2: String): Int = {
      val l1 = mapper.getOrElse(word1, Nil)
      val l2 = mapper.getOrElse(word2, Nil)

      l1.flatMap(i1 => l2.map(i2 => (i1 - i2).abs)).reduceOption(_.min(_)).getOrElse(Int.MaxValue)
    }
  }
}
