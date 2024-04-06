package leetCode._400

import scala.collection.immutable.BitSet

object Solution_318 {
  def maxProduct(words: Array[String]): Int = {
    val bitSets = words.map(_.iterator.map(_ - 'a').foldLeft(BitSet.empty)((bs, char) => bs + char))
    Iterator
      .range(0, words.length)
      .flatMap(i => Iterator.range(i + 1, words.length).map(i -> _))
      .collect { case (i, j) if (bitSets(i) & bitSets(j)).isEmpty => words(i).length * words(j).length }
      .reduceOption(_.max(_))
      .getOrElse(0)
  }
}
