package leetCode._1200

object Solution_1199 {
  def minBuildTime(blocks: Array[Int], split: Int): Int = {
    val pq = new java.util.PriorityQueue[Int]()

    blocks.foreach(pq.add)

    while (pq.size > 1) {
      pq.poll()
      val b = pq.poll()
      pq.add(split + b)
    }

    pq.peek
  }
}
