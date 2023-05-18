package leetCode

import scala.collection.mutable

object Solution_2671 {
  class FrequencyTracker() {

    private val counts = mutable.Map.empty[Int, Int].withDefaultValue(0)

    private val frequencies = mutable.Map.empty[Int, Int].withDefaultValue(0)

    def add(number: Int): Unit = {
      val frequency = counts(number)
      frequencies(frequency) -= 1
      frequencies(frequency + 1) += 1
      counts(number) += 1
    }

    def deleteOne(number: Int): Unit = {
      val frequency = counts(number)
      if (frequency > 0) {
        frequencies(frequency) -= 1
        frequencies(frequency - 1) += 1
        counts(number) -= 1
      }
    }

    def hasFrequency(frequency: Int): Boolean =
      frequencies(frequency) > 0
  }
}
