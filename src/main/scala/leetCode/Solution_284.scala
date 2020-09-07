package leetCode

object Solution_284 {

  class PeekingIterator(iterator: Iterator[Int]) extends Iterator[Int] {
    var cur = 0
    var isPeek = false

    def peek(): Int = {
      if (isPeek) cur
      else {
        isPeek = true
        cur = iterator.next
        cur
      }
    }

    override def next(): Int = {
      if (isPeek) {
        isPeek = false
        cur
      } else iterator.next
    }

    override def hasNext(): Boolean = isPeek || iterator.hasNext
  }

}
