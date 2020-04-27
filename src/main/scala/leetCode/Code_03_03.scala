package leetCode

import java.util

object Code_03_03 {

  class StackOfPlates(_cap: Int) {

    private var list = Array.empty[util.Deque[Int]]
    private val cap = _cap

    def push(`val`: Int) {
      if (list.isEmpty) {
        if (cap == 0) return
        var d = new util.LinkedList[Int]()
        d.push(`val`)
        list :+= d
      } else {
        val last = list(list.length - 1)
        if (last.size() < cap) last.push(`val`)
        else {
          var s = new util.LinkedList[Int]()
          s.push(`val`)
          list :+= s
        }
      }
    }

    def pop(): Int = {
      if (list.isEmpty) -1
      else {
        val last = list(list.length - 1)
        val r = last.poll()
        if (last.isEmpty) list.drop(list.length - 1)
        r
      }
    }

    def popAt(index: Int): Int = {
      if (index >= list.length) -1
      else {
        val cur = list(index)
        val r = cur.poll()
        if (cur.isEmpty) list.drop(index)
        r
      }
    }

  }

}
