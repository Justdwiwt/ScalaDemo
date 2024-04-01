package leetCode._900

object Solution_820 {
  def minimumLengthEncoding(words: Array[String]): Int = words
    .foldLeft(words.toSet)((set, w) => set -- (1 until w.length).map(w.substring))
    .toSeq
    .map(_.length + 1)
    .sum
}
