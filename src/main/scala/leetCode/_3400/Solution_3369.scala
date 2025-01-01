package leetCode._3400

object Solution_3369 {
  class StatisticsTracker {
    private val queue = collection.mutable.Queue.empty[Int]
    private val frequencies = collection.mutable.Map.empty[Int, Int].withDefaultValue(0)
    private val frequencyNumbers = collection.mutable.TreeMap.empty[Int, collection.mutable.TreeSet[Int]]
    private val higher = collection.mutable.PriorityQueue.empty[Int](Ordering[Int].reverse)
    private val lower = collection.mutable.PriorityQueue.empty[Int]
    private val removals = collection.mutable.Map.empty[Int, Int].withDefaultValue(0)
    private var higherSize = 0
    private var lowerSize = 0
    private var sum: Long = 0

    def addNumber(number: Int): Unit = {
      queue.enqueue(number)
      frequencies(number) += 1
      val frequency = frequencies(number)
      frequencyNumbers.getOrElseUpdate(frequency, scala.collection.mutable.TreeSet[Int]()).add(number)
      if (frequency > 1) {
        frequencyNumbers(frequency - 1).remove(number)
        if (frequencyNumbers(frequency - 1).isEmpty) frequencyNumbers -= (frequency - 1)
      }
      addNumberToPriorityQueue(number)
      sum += number
    }

    def removeFirstAddedNumber(): Unit = {
      val number = queue.dequeue()
      frequencies(number) -= 1
      val frequency = frequencies(number)
      if (frequency == 0) frequencies -= number
      if (frequency > 0) frequencyNumbers.getOrElseUpdate(frequency, scala.collection.mutable.TreeSet[Int]()).add(number)
      frequencyNumbers(frequency + 1).remove(number)
      if (frequencyNumbers(frequency + 1).isEmpty) frequencyNumbers -= (frequency + 1)
      removeNumberFromPriorityQueue(number)
      sum -= number
    }

    def getMean: Int =
      (sum / queue.size).toInt

    def getMedian: Int =
      higher.head

    def getMode: Int =
      frequencyNumbers.last._2.head

    private def addNumberToPriorityQueue(number: Int): Unit = {
      if (higher.isEmpty || number >= higher.head) {
        higher.enqueue(number)
        higherSize += 1
      } else {
        lower.enqueue(number)
        lowerSize += 1
      }
      adjustPriorityQueues()
    }

    private def removeNumberFromPriorityQueue(number: Int): Unit = {
      removals(number) += 1
      if (number >= higher.head) higherSize -= 1
      else lowerSize -= 1
      adjustPriorityQueues()
    }

    private def adjustPriorityQueues(): Unit = {
      if (higherSize > lowerSize + 1) {
        lower.enqueue(higher.dequeue())
        higherSize -= 1
        lowerSize += 1
      } else if (higherSize < lowerSize) {
        higher.enqueue(lower.dequeue())
        higherSize += 1
        lowerSize -= 1
      }
      Seq(higher, lower).foreach(pq => {
        while (pq.nonEmpty && removals.contains(pq.head)) {
          val number = pq.dequeue()
          removals(number) -= 1
          if (removals(number) == 0) removals -= number
        }
      })
    }
  }
}
