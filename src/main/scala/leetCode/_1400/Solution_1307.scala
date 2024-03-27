package leetCode._1400

import scala.collection.immutable.BitSet

object Solution_1307 {
  // fixme

  def isSolvable(words: Array[String], result: String): Boolean = words.iterator.forall(_.length <= result.length) && {
    val charsByColumn = result.indices.map(i => words
      .iterator
      .flatMap(word => Some(i + word.length - result.length).collect { case j if word.isDefinedAt(j) => word(j) })
      .toSeq
    )

    @scala.annotation.tailrec
    def sumChars(chars: Seq[Char], bindings: Map[Char, Int], sum: Int = 0): Option[Int] = chars match {
      case char :: chars => bindings.get(char) match {
        case Some(value) => sumChars(chars, bindings, sum + value)
        case _ => None
      }
      case _ => Some(sum)
    }

    val reverseChar = charsByColumn.reverse.zip(result.reverse).toList

    def isPossiblySolvable(bindings: Map[Char, Int]) = {
      @scala.annotation.tailrec
      def isPossiblySolvable(ch: List[(Seq[Char], Char)], carry: Int): Boolean = ch match {
        case (wordChars, resultChar) :: remainingCh =>
          sumChars(wordChars, bindings).flatMap(wordCharSum => {
            val updatedSum = wordCharSum + carry
            bindings.get(resultChar).map(resultDigit => (updatedSum % 10 == resultDigit, updatedSum / 10))
          }) match {
            case Some((true, newCarry)) => isPossiblySolvable(remainingCh, newCarry)
            case _ => true
          }
        case _ => carry == 0
      }

      isPossiblySolvable(reverseChar, 0)
    }

    val nonZeroChars = (result +: words).collect { case s if s.length > 1 => s.head }.toSet

    def isSolvable(chars: Seq[Char], values: Set[Int], bindings: Map[Char, Int]): Boolean = chars match {
      case char :: chars => (if (nonZeroChars.contains(char)) values - 0 else values)
        .iterator
        .map(value => (values - value, bindings + (char -> value)))
        .collect { case (values, bindings) if isPossiblySolvable(bindings) => isSolvable(chars, values, bindings) }
        .contains(true)
      case _ => true
    }

    isSolvable(reverseChar
      .iterator
      .flatMap { case (wordChars, resultChar) => resultChar +: wordChars }
      .toSeq
      .distinct,
      BitSet(0 until 9: _*),
      Map.empty
    )
  }
}
