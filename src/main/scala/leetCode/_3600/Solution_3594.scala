package leetCode._3600

import scala.collection.mutable
import scala.math._

object Solution_3594 {
  def minTime(n: Int, k: Int, m: Int, time: Array[Int], mul: Array[Double]): Double = {
    val U = 1 << n
    val maxTime = Array.fill(U)(0)
    (0 until n).foreach(i => {
      val t = time(i)
      val highBit = 1 << i
      (0 until highBit).foreach(mask => maxTime(highBit | mask) = maxTime(mask).max(t))
    })

    val subMasks = Array.fill(U)(mutable.ArrayBuffer[Int]())
    (0 until U).foreach(mask => {
      var sub = mask
      while (sub > 0) {
        if (Integer.bitCount(sub) <= k) subMasks(mask) += sub
        sub = (sub - 1) & mask
      }
    })

    val inf = 1e18
    val dis = Array.fill(m, U, 2)(inf)
    implicit val ord: Ordering[(Double, Int, Int, Int)] = Ordering.by(-_._1)
    val pq = mutable.PriorityQueue.empty[(Double, Int, Int, Int)]

    def push(d: Double, stage: Int, mask: Int, dir: Int): Unit = {
      if (d < dis(stage)(mask)(dir)) {
        dis(stage)(mask)(dir) = d
        pq.enqueue((d, stage, mask, dir))
      }
    }

    push(0.0, 0, U - 1, 0)

    while (pq.nonEmpty) {
      val (d, stage, left, dir) = pq.dequeue()
      if (left == 0) return d
      if (d > dis(stage)(left)(dir)) ()

      if (dir == 0) subMasks(left).foreach(sub => {
        val cost = maxTime(sub) * mul(stage)
        val nextStage = (stage + floor(cost)).toInt % m
        push(d + cost, nextStage, left ^ sub, 1)
      }) else {
        val gone = (1 << n) - 1 ^ left
        var s = gone
        while (s > 0) {
          val lb = s & -s
          val cost = maxTime(lb) * mul(stage)
          val nextStage = (stage + floor(cost)).toInt % m
          push(d + cost, nextStage, left ^ lb, 0)
          s ^= lb
        }
      }
    }

    -1.0
  }
}
