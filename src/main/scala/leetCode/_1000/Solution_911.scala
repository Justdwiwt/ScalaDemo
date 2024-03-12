package leetCode._1000

import scala.collection.Searching.{Found, InsertionPoint, search}

object Solution_911 {
  class TopVotedCandidate(_persons: Array[Int], _times: Array[Int]) {

    val n: Int = _persons.length
    val votes: Array[Int] = Array.fill(n)(0)
    val rank: Array[Int] = (0 until n).toArray
    val sorted: Array[Int] = (0 until n).toArray
    private val lead = new Array[Int](n)

    private var nextStat = 0

    def update(index: Int): Int = {
      (nextStat to index).foreach(i => {
        val person = _persons(i)
        votes(person) += 1
        val vote = votes(person)
        var r = rank(person)
        while (r > 0 && vote >= votes(sorted(r - 1))) {
          val p2 = sorted(r - 1)
          rank(p2) = r
          sorted(r) = p2
          r -= 1
        }
        rank(person) = r
        sorted(r) = person
        lead(i) = sorted.head
      })
      nextStat = List(index + 1, nextStat).max
      lead(index)
    }

    def q(t: Int): Int = {
      val index = _times.search(t) match {
        case Found(idx) => idx
        case InsertionPoint(idx) => idx - 1
      }
      update(index)
    }

  }
}
