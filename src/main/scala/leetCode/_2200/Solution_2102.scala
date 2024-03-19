package leetCode._2200

import scala.collection.Searching.search
import scala.collection.mutable

object Solution_2102 {
  class SORTracker {
    private val locations = mutable.Buffer.empty[(Int, String)]
    private var queryCount = -1

    def add(name: String, score: Int): Unit =
      locations.insert(locations.search((-score, name)).insertionPoint, (-score, name))

    def get(): String = {
      queryCount += 1
      locations(queryCount)._2
    }
  }
}
