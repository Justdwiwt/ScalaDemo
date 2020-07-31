package leetCode

import scala.collection.mutable.ArrayBuffer

object XH_4_1 {

  class LCStack() {

    private var arr = new ArrayBuffer[Int]()

    def push(x: Int) {
      arr :+= x
    }

    def pop() {
      arr.remove(arr.length - 1)
    }

    def size(): Int = arr.length

    def top(): Int = arr.last

  }

}
