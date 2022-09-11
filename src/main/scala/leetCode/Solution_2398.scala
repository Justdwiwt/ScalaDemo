package leetCode

import scala.collection.immutable.TreeMap

object Solution_2398 {
  def maximumRobots(chargeTimes: Array[Int], runningCosts: Array[Int], budget: Long): Int = {
    @scala.annotation.tailrec
    def f(i: Int, j: Int, mx: Int, runningSum: Long, mxS: TreeMap[Int, Int]): Int = {
      val ji = j - i + 1
      val cost = mxS.lastOption.fold(0)(_._1) + ji * runningSum

      if (j + 1 >= chargeTimes.length) if (cost > budget) mx else mx.max(ji)
      else {
        if (i > j || cost <= budget) {
          val charge = chargeTimes(j + 1)
          val nMxS = mxS.updated(charge, mxS.getOrElse(charge, 0) + 1)
          f(i, j + 1, mx.max(ji), runningSum + runningCosts(j + 1), nMxS)
        }
        else {
          val charge = chargeTimes(i)
          val nMxS = if (mxS(charge) == 1) mxS.drop(charge) else mxS.updated(charge, mxS(charge) - 1)
          f(i + 1, j, mx, runningSum - runningCosts(i), nMxS)
        }
      }
    }

    f(0, -1, 0, 0, TreeMap.empty)
  }
}
