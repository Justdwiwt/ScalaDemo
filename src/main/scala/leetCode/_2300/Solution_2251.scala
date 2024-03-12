package leetCode._2300

import scala.collection.mutable

object Solution_2251 {
  def fullBloomFlowers(flowers: Array[Array[Int]], persons: Array[Int]): Array[Int] = {
    val sortedFlowers = flowers.sortWith((a: Array[Int], b: Array[Int]) => a.head <= b.head)
    val pq = mutable.PriorityQueue[Int]()((a: Int, b: Int) => sortedFlowers(b)(1) - sortedFlowers(a)(1))
    val sortedPersons = persons.zipWithIndex.sorted
    val res = Array.fill(persons.length)(0)
    var flowerIdx = 0
    sortedPersons.foreach { case (arrivalTime, idx) =>
      while (flowerIdx < sortedFlowers.length && sortedFlowers(flowerIdx).head <= arrivalTime) {
        pq += flowerIdx
        flowerIdx += 1
      }
      while (pq.nonEmpty && sortedFlowers(pq.head)(1) < arrivalTime) {
        pq.dequeue()
      }
      res(idx) = pq.size
    }
    res
  }
}
