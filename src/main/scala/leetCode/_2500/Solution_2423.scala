package leetCode._2500

object Solution_2423 {
  def equalFrequency(word: String): Boolean = word
    .indices
    ./:(false)((res, idx) => res | (word.substring(0, idx) + word.substring(idx + 1, word.length))
      .groupBy(identity)
      .mapValues(_.length)
      .values
      .groupBy(identity)
      .size == 1
    )
}
