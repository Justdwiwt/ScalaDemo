package leetCode

object Solution_703 {

  class KthLargest(_k: Int, _nums: Array[Int]) {

    private val k = _k
    private val pq = new java.util.PriorityQueue[Int](k)

    _nums.foreach(i => add(i))

    def add(`val`: Int): Int = {
      if (pq.size < k) pq.offer(`val`)
      else if (pq.peek() < `val`) {
        pq.poll()
        pq.offer(`val`)
      }
      pq.peek
    }

  }

}

