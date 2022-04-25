package leetCode

object Solution_284 {

  class GenPeekingIterator[A](iterator: Iterator[A]) {
    var peeked: Option[A] = None

    def peek(): A = peeked.getOrElse {
      val res = iterator.next()
      peeked = Some(res)
      res
    }

    def next(): A = peeked.fold(iterator.next) { x =>
      peeked = None
      x
    }

    def hasNext(): Boolean = peeked.nonEmpty || iterator.hasNext
  }

  class PeekingIterator(it: Iterator[Int]) extends GenPeekingIterator[Int](it)

}
