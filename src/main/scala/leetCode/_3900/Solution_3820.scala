package leetCode._3900

object Solution_3820 {
  def specialNodes(n: Int, edges: Array[Array[Int]], x: Int, y: Int, z: Int): Int = {
    val g = Array.fill(n)(collection.mutable.ArrayBuffer[Int]())
    edges.foreach { e =>
      val a = e(0)
      val b = e(1)
      g(a) += b
      g(b) += a
    }

    def bfs(start: Int): Array[Int] = {
      val dist = Array.fill(n)(-1)
      val q = collection.mutable.Queue[Int]()

      dist(start) = 0
      q.enqueue(start)

      while (q.nonEmpty) {
        val u = q.dequeue()
        g(u).foreach(v => {
          if (dist(v) == -1) {
            dist(v) = dist(u) + 1
            q.enqueue(v)
          }
        })
      }

      dist
    }

    val dx = bfs(x)
    val dy = bfs(y)
    val dz = bfs(z)

    (0 until n).count(i => {
      val arr = Array(dx(i), dy(i), dz(i)).sorted
      val a = arr(0).toLong
      val b = arr(1).toLong
      val c = arr(2).toLong
      a * a + b * b == c * c
    })
  }
}
