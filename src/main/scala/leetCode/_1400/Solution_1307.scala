package leetCode._1400

import scala.collection.immutable.BitSet

object Solution_1307 {
  // TODO:

  //  def isSolvable(words: Array[String], result: String): Boolean = words.iterator.forall(_.length <= result.length) && {
  //    val charsByColumn = result.indices.map(i => words
  //      .iterator
  //      .flatMap(word => Some(i + word.length - result.length).collect { case j if word.isDefinedAt(j) => word(j) })
  //      .toSeq
  //    )
  //
  //    @scala.annotation.tailrec
  //    def sumChars(chars: Seq[Char], bindings: Map[Char, Int], sum: Int = 0): Option[Int] = chars match {
  //      case char :: chars => bindings.get(char) match {
  //        case Some(value) => sumChars(chars, bindings, sum + value)
  //        case _ => None
  //      }
  //      case _ => Some(sum)
  //    }
  //
  //    val reverseWordCharsAndResultChar = charsByColumn.reverse.zip(result.reverseIterator)
  //
  //    def isPossiblySolvable(bindings: Map[Char, Int]) = {
  //      @scala.annotation.tailrec
  //      def isPossiblySolvable(reverseWordCharsAndResultChar: Iterable[(Seq[Char], Char)], carry: Int): Boolean = {
  //        reverseWordCharsAndResultChar.headOption match {
  //          case Some(wordChars -> resultChar) => sumChars(wordChars, bindings).map(_ + carry).zip(bindings.get(resultChar)) match {
  //            case Some(wordCharSum -> resultDigit) => wordCharSum % 10 == resultDigit && isPossiblySolvable(reverseWordCharsAndResultChar.tail, wordCharSum / 10)
  //            case _ => true
  //          }
  //          case _ => carry == 0
  //        }
  //      }
  //
  //      isPossiblySolvable(reverseWordCharsAndResultChar, 0)
  //    }
  //
  //    val nonZeroChars = Iterator(result).concat(words).collect { case s if s.length > 1 => s.head }.toSet
  //
  //    def isSolvable(chars: Seq[Char], values: Set[Int], bindings: Map[Char, Int]): Boolean = chars match {
  //      case char :: chars => (if (nonZeroChars.contains(char)) values - 0 else values)
  //        .iterator
  //        .map(value => (values - value, bindings + (char -> value)))
  //        .collect { case (values, bindings) if isPossiblySolvable(bindings) => isSolvable(chars, values, bindings) }
  //        .contains(true)
  //      case _ => true
  //    }
  //
  //    isSolvable(reverseWordCharsAndResultChar
  //      .iterator
  //      .flatMap { case (wordChars, resultChar) => Iterator(resultChar).concat(wordChars) }
  //      .distinct
  //      .toSeq,
  //      (0 to 9).to(BitSet),
  //      Map.empty
  //    )
  //  }
}
