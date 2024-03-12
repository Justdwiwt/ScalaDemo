package leetCode._2200

object Solution_2122 {
  def recoverArray(nums: Array[Int]): Array[Int] = {
    val sorted = nums.sorted
    sorted.indices.drop(1).withFilter(i => (sorted(i) - sorted.head) != 0 && ((sorted(i) - sorted.head) % 2 != 1)).foreach(i => {
      val M = sorted(i) - sorted.head
      val q = new java.util.LinkedList[Int]
      val res = Array.fill(sorted.length / 2)(0)
      var t = 0
      sorted.indices.foreach(j => {
        if (!q.isEmpty && q.peek() == sorted(j)) {
          res(t) = q.poll() - M / 2
          t += 1
        } else q.offer(sorted(j) + M)
      })
      if (q.isEmpty) return res
    })
    Array(0)
  }
}
