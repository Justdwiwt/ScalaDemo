package leetCode._2200

import scala.collection.mutable

object Solution_2174 {
  def removeOnes(grid: Array[Array[Int]]): Int = {
    val m = grid.length
    val n = grid.head.length
    var start = 0
    grid.indices.foreach(i => grid.head.indices.foreach(j => start += grid(i)(j) << (i * n + j)))

    if (start == 0) return 0

    val complete = (1 << (m * n)) - 1
    val rowMasks = Array.fill(m)(complete)
    val colMasks = Array.fill(n)(complete)
    grid.indices.foreach(i => grid.head.indices.foreach(j => {
      val currBit = 1 << (i * n + j)
      rowMasks(i) -= currBit
      colMasks(j) -= currBit
    }))

    val visited = mutable.HashSet.empty[Int]
    visited.add(start)
    val queue = mutable.Queue.empty[Int]
    queue.enqueue(start)

    var minOperations = -1
    var steps = 0
    while (queue.nonEmpty && minOperations < 0) {
      steps += 1
      val size = queue.size
      (0 until size)
        .withFilter(_ => minOperations < 0)
        .foreach(_ => {
          val state = queue.dequeue()
          grid.indices.foreach(i => grid.head.indices.foreach(j => if ((state & (1 << (i * n + j))) != 0) {
            val next = state & rowMasks(i) & colMasks(j)
            if (next == 0) minOperations = steps
            else if (visited.add(next)) queue.enqueue(next)
          }))
        })
    }
    minOperations
  }
}
