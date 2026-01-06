package leetCode._3800

object Solution_3709 {

}

import scala.collection.Searching._
import scala.collection.mutable.ArrayBuffer

class ExamTracker() {

  private val times = ArrayBuffer.empty[Int]
  private val preSum = ArrayBuffer(0L)

  def record(time: Int, score: Int): Unit = {
    times += time
    preSum += preSum.last + score
  }

  def totalScore(startTime: Int, endTime: Int): Long = {
    val left = lowerBound(times, startTime)
    val right = upperBound(times, endTime)
    preSum(right) - preSum(left)
  }

  private def lowerBound(arr: ArrayBuffer[Int], target: Int): Int =
    arr.search(target) match {
      case Found(idx) => idx
      case InsertionPoint(idx) => idx
    }

  private def upperBound(arr: ArrayBuffer[Int], target: Int): Int =
    arr.search(target + 1) match {
      case Found(idx) => idx
      case InsertionPoint(idx) => idx
    }
}
