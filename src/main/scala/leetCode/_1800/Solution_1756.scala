package leetCode._1800

import scala.collection.mutable.ArrayBuffer

object Solution_1756 {
  class MRUQueue(n: Int) {
    var res: ArrayBuffer[Int] = ArrayBuffer.range(1, n + 1)

    def fetch(k: Int): Int = {
      val index = k - 1
      val ret = res(index)
      res.remove(index)
      res += ret
      ret
    }
  }
}
