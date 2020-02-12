package leetCode

import scala.collection.mutable

object Offer_09 {

  class CQueue() {

    private val s1 = new mutable.Stack[Int]
    private val s2 = new mutable.Stack[Int]

    def appendTail(value: Int): Unit = s1.push(value)

    def deleteHead(): Int = {
      if (s2.isEmpty) {
        if (s1.isEmpty) return -1
        while (s1.nonEmpty) {
          s2.push(s1.head)
          s1.pop()
        }
      }
      val t = s2.head
      s2.pop()
      t
    }

  }

}
