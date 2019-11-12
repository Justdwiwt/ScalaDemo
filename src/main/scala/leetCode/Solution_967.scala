package leetCode

import scala.collection.mutable.ArrayBuffer

object Solution_967 {
  def numsSameConsecDiff(N: Int, K: Int): Array[Int] = N match {
    case 1 => Array.range(0, 10)
    case _ =>
      val res = new ArrayBuffer[Int]()

      def func(i: Int): Unit = {
        if (math.log10(i).toInt + 1 == N) {
          res += i
          return
        }
        val pre = i % 10
        if (pre >= K) func(10 * i + pre - K)
        if (K != 0 && pre + K <= 9) func(10 * i + pre + K)
      }

      (1 to 9).foreach(i => func(i))
      val t = new Array[Int](res.length)
      res.indices.foreach(i => t(i) = res(i))
      t
  }
}
