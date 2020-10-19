package leetCode

object Solution_1265 {

  class ImmutableListNode {
    def printValue(): Unit = {}

    def getNext(): ImmutableListNode = ???
  }

  def printLinkedListInReverse(head: ImmutableListNode): Unit = head match {
    case null =>
    case _ =>
      printLinkedListInReverse(head.getNext())
      head.printValue()
  }
}
