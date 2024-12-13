package leetCode._3400

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Solution_3377 {
  def minOperations(n: Int, m: Int): Int = {
    val maxUnit = getMaxUnit(n)
    val maxNum = maxUnit * 10 - 1
    val isPrime = getPrimes(maxNum)
    if (isPrime(n) || isPrime(m)) return -1

    var minCost = -1
    val numsCosts = mutable.Map[Int, Int](n -> n)
    val pq = mutable.PriorityQueue[(Int, Int)]()(Ordering.by(-_._2))
    pq += ((n, n))

    while (pq.nonEmpty && minCost < 0) {
      val (num, cost) = pq.dequeue()
      if (num == m) minCost = cost
      else if (numsCosts.getOrElse(num, Int.MaxValue) >= cost) {
        val nextNums = getNextNums(num, maxUnit)
        nextNums.foreach(nextNum => {
          if (!isPrime(nextNum) && cost + nextNum < numsCosts.getOrElse(nextNum, Int.MaxValue)) {
            numsCosts += nextNum -> (cost + nextNum)
            pq += ((nextNum, cost + nextNum))
          }
        })
      }
    }
    minCost
  }

  private def getMaxUnit(n: Int): Int = {
    var unit = 1
    var temp = n
    while (temp >= 10) {
      temp /= 10
      unit *= 10
    }
    unit
  }

  private def getPrimes(maxNum: Int): Array[Boolean] = {
    val isPrime = Array.fill(maxNum + 1)(true)
    isPrime(0) = false
    isPrime(1) = false
    (2 to maxNum).withFilter(isPrime(_)).foreach(i => (i * 2 to maxNum by i).foreach(isPrime(_) = false))
    isPrime
  }

  private def getNextNums(num: Int, maxUnit: Int): ListBuffer[Int] = {
    val nextNums = ListBuffer[Int]()
    Iterator.iterate(1)(_ * 10).takeWhile(_ <= maxUnit).foreach(unit => {
      val digit = num / unit % 10
      if (digit < 9) nextNums += (num + unit)
      if ((unit != maxUnit && digit > 0) || digit > 1) nextNums += (num - unit)
    })
    nextNums
  }
}
