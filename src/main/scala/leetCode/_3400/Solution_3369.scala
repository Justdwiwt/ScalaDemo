package leetCode._3400

import scala.collection.mutable

// fixme: case 476/1246 wrong answer
object Solution_3369 {
  class StatisticsTracker() {
    private var sum: Long = 0
    private var count: Int = 0

    private val sortedList = new mutable.TreeMap[Int, Int]()

    private val frequencyMap = new mutable.HashMap[Int, Int]()

    private val queue = new mutable.Queue[Int]()

    def addNumber(number: Int): Unit = {
      sum += number
      count += 1
      queue.enqueue(number)

      frequencyMap.put(number, frequencyMap.getOrElse(number, 0) + 1)

      sortedList.put(number, sortedList.getOrElse(number, 0) + 1)
    }

    def removeFirstAddedNumber(): Unit = {
      if (queue.nonEmpty) {
        val number = queue.dequeue()
        sum -= number
        count -= 1

        frequencyMap.put(number, frequencyMap(number) - 1)
        if (frequencyMap(number) == 0) frequencyMap.remove(number)

        sortedList.put(number, sortedList(number) - 1)
        if (sortedList(number) == 0) sortedList.remove(number)
      }
    }

    def getMean(): Int = {
      if (count == 0) 0
      else (sum / count).toInt
    }

    def getMedian(): Int = {
      if (count == 0) 0
      else {
        val midIndex = count / 2
        var currentIndex = 0
        var median = 0

        sortedList.foreach { case (key, value) =>
          currentIndex += value
          if (currentIndex > midIndex) median = key
        }
        median
      }
    }

    def getMode(): Int =
      if (count == 0) 0
      else frequencyMap.maxBy(_._2)._1
  }
}
