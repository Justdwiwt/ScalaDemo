package leetCode

import scala.collection.mutable

object Solution_341 {

  class NestedIterator(_nestedList: List[NestedInteger]) {
    private val q = new mutable.Queue[Int]()

    flatten(_nestedList)

    def flatten(list: Seq[NestedInteger]): Unit = {
      if (list != null && list.nonEmpty) {
        val head = list.head
        if (head.isInteger) q.enqueue(head.getInteger)
        else flatten(head.getList)
        flatten(list.tail)
      }
    }

    def next(): Int = q.dequeue

    def hasNext: Boolean = q.nonEmpty

  }

}

class NestedInteger {

  def isInteger: Boolean = ???

  def getInteger: Int = ???

  def setInteger(i: Int): Nothing = ???

  def getList: List[NestedInteger] = ???

  def add(ni: NestedInteger): Nothing = ???
}
