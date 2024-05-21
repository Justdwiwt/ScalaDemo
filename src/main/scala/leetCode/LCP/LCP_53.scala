package leetCode.LCP

import scala.util.control.Breaks.{break, breakable}

object LCP_53 {
  def defendSpaceCity(time: Array[Int], position: Array[Int]): Int = {
    val n = position.max
    val m = 1 << time.max
    val rain = Array.fill(n + 1)(0)
    time.indices.foreach(i => rain(position(i)) |= 1 << (time(i) - 1))

    val union = Array.fill(m)(0)
    val single = Array.fill(m)(0)

    def calculateUnionAndSingle(i: Int, lb: Int, j: Int, lb2: Int): Unit = {
      union(i) = union(j) + (if (lb == (lb2 >> 1)) 1 else 3)
      single(i) = single(j) + (if (lb == (lb2 >> 1)) 1 else 2)
    }

    (1 until m).foreach(i => {
      val lb = i & -i
      val j = i ^ lb
      val lb2 = j & -j
      calculateUnionAndSingle(i, lb, j, lb2)
    })

    val arr = Array.ofDim[Int](n + 1, m)
    (0 until m).foreach(j => arr.head(j) = union(j) + single(((m - 1) ^ j) & rain.head))

    def updateF(i: Int): Unit = {
      java.util.Arrays.fill(arr(i), Int.MaxValue / 2)
      (0 until m).foreach(j => {
        val mask = (m - 1) ^ j
        var pre = mask
        breakable(while (true) {
          val cost = arr(i - 1)(pre) + union(j) + single((mask ^ pre) & rain(i))
          arr(i)(j) = arr(i)(j).min(cost)
          if (pre == 0) break
          pre = (pre - 1) & mask
        })
      })
    }

    (1 to n).foreach(updateF)
    arr(n).head
  }
}
