package leetCode._2400

import scala.collection.mutable

object Solution_2336 {
  class SmallestInfiniteSet() {
    private val st = mutable.Set.empty[Int]
    private var smallest = 1

    def popSmallest(): Int = {
      st += smallest
      val output = smallest
      smallest = Iterator.from(smallest + 1).find(!st.contains(_)).get
      output
    }

    def addBack(num: Int): Unit = {
      st -= num
      smallest = math.min(num, smallest)
    }
  }
}
