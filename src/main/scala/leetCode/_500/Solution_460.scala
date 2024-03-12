package leetCode._500

import scala.collection.mutable

object Solution_460 {
  class LFUCache(_capacity: Int) {

    class ListNode(val key: Int,
                   var value: Int,
                   var freq: Freq,
                   var prev: ListNode = null,
                   var next: ListNode = null)

    class Freq(val freq: Int,
               var higher: Freq = null,
               var lower: Freq = null,
               val HEAD: ListNode = new ListNode(0, 0, null),
               val TAIL: ListNode = new ListNode(0, 0, null)) {

      private def chain(prev: ListNode, next: ListNode): Unit = {
        prev.next = next
        next.prev = prev
      }

      chain(HEAD, TAIL)

      def appendAndCopy(node: ListNode): ListNode = {
        val copy = new ListNode(node.key, node.value, this)
        chain(copy, HEAD.next)
        chain(HEAD, copy)
        copy
      }

      def remove(node: ListNode): Unit =
        chain(node.prev, node.next)

      def dropTail: ListNode = {
        val res = TAIL.prev
        remove(res)
        res
      }

      def isEmpty: Boolean =
        HEAD.next == TAIL
    }

    def chain(prev: Freq, next: Freq): Unit = {
      prev.lower = next
      next.higher = prev
    }

    val ZERO_FREQ = new Freq(0)
    val INF_FREQ = new Freq(Integer.MAX_VALUE)
    chain(INF_FREQ, ZERO_FREQ)
    private val map = mutable.HashMap.empty[Int, ListNode]

    def getInternal(key: Int): Option[ListNode] = map.get(key).map(node => {
      val freq = node.freq
      if (freq.higher == INF_FREQ || freq.higher.freq != freq.freq + 1) {
        val newFreq = new Freq(freq.freq + 1)
        chain(freq.higher, newFreq)
        chain(newFreq, freq)
      }
      val copy = freq.higher.appendAndCopy(node)
      freq.remove(node)
      map += key -> copy
      if (freq != ZERO_FREQ && freq.isEmpty) chain(freq.higher, freq.lower)
      copy
    })

    def get(key: Int): Int = {
      if (_capacity == 0) return -1
      getInternal(key).map(_.value).getOrElse(-1)
    }

    def put(key: Int, value: Int): Unit = {
      if (_capacity == 0) return
      map.get(key) match {
        case Some(_) => getInternal(key).foreach(_.value = value)
        case None => if (_capacity == size) {
          map.remove(ZERO_FREQ.higher.dropTail.key)
          if (ZERO_FREQ.higher.isEmpty) chain(ZERO_FREQ.higher.higher, ZERO_FREQ)
        }
          val newNode = new ListNode(key, value, ZERO_FREQ)
          map += key -> ZERO_FREQ.appendAndCopy(newNode)
          getInternal(key)
      }
    }

    def size: Int = map.size
  }
}
