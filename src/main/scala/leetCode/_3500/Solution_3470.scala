package leetCode._3500

import scala.collection.mutable.ListBuffer

object Solution_3470 {
  val f: ListBuffer[Long] = ListBuffer(1L)
  (1 to 100).foreach(i => {
    if (f.last < 1e15) {
      f += f.last * i
      f += f.last * i
    }
  })

  def permute(n: Int, k: Long): Array[Int] = {
    var kAdjusted = k - 1
    if (n < f.length && kAdjusted >= f(n) * (2 - n % 2))
      return Array.emptyIntArray

    val cand: Array[ListBuffer[Int]] = Array.fill(2)(ListBuffer.empty[Int])

    (2 to n by 2).foreach(i => cand(0) += i)
    (1 to n by 2).foreach(i => cand(1) += i)

    val ans = new Array[Int](n)
    var parity = 1

    (0 until n).foreach(i => {
      var j = 0
      if (n - 1 - i < f.length) {
        val size = f(n - 1 - i)
        j = (kAdjusted / size).toInt
        kAdjusted %= size

        if (n % 2 == 0 && i == 0) {
          parity = 1 - j % 2
          j /= 2
        }
      }

      ans(i) = cand(parity)(j)
      cand(parity).remove(j)
      parity ^= 1
    })

    ans
  }
}
