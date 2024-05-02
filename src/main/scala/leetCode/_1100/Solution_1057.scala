package leetCode._1100

import scala.collection.mutable.ArrayBuffer

object Solution_1057 {
  private def manhattan(p1: Array[Int], p2: Array[Int]): Int =
    (p1.head - p2.head).abs + (p1(1) - p2(1)).abs

  def assignBikes(workers: Array[Array[Int]], bikes: Array[Array[Int]]): Array[Int] = {
    val res = Array.fill(workers.length)(-1)
    val distances = ArrayBuffer.empty[(Int, Int, Int)]

    workers.indices.foreach(i => bikes.indices.foreach(j => distances += ((manhattan(workers(i), bikes(j)), i, j))))

    val sorted = distances.sortBy(_._1)

    val assignedBikes = Array.fill(bikes.length)(false)
    val assignedWorkers = Array.fill(workers.length)(false)

    sorted.foreach { case (_, workerIdx, bikeIdx) =>
      if (!assignedWorkers(workerIdx) && !assignedBikes(bikeIdx)) {
        res(workerIdx) = bikeIdx
        assignedWorkers(workerIdx) = true
        assignedBikes(bikeIdx) = true
      }
    }

    res
  }
}
