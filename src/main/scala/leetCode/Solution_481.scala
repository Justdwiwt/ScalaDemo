package leetCode

import scala.collection.mutable.ArrayBuffer

object Solution_481 {
  def magicalString(n: Int): Int = {
    if (n <= 0) return 0
    if (n <= 3) return 1
    var res = 1
    var head = 2
    var tail = 3
    var num = 1
    val v = new ArrayBuffer[Int]()
    v.append(1, 2, 2)
    while (tail < n) {
      (0 until v(head)).foreach(_ => {
        v.append(num)
        if (num == 1 && tail < n) res += 1
        tail += 1
      })
      num ^= 3
      head += 1
    }
    res
  }
}
