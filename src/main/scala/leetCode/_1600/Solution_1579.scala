package leetCode._1600

object Solution_1579 {

  class UF(n: Int) {
    val p: Array[Int] = Array.fill(n)(0)
    var cnt: Int = n
    (0 until n).foreach(i => p(i) = i)

    def find(x: Int): Int = {
      if (x != p(x)) p(x) = find(p(x))
      p(x)
    }

    def union(x: Int, y: Int): Boolean = {
      val px = find(x)
      val py = find(y)
      if (px != py) {
        p(px) = py
        cnt -= 1
        return true
      }
      false
    }
  }

  def maxNumEdgesToRemove(n: Int, edges: Array[Array[Int]]): Int = {
    val A = new UF(n)
    val B = new UF(n)
    var remove = 0
    edges.foreach(e => if (e.head == 3) {
      if (!A.union(e(1) - 1, e(2) - 1)) remove += 1
      else B.union(e(1) - 1, e(2) - 1)
    })
    edges.foreach(e => e.head match {
      case 1 => if (!A.union(e(1) - 1, e(2) - 1)) remove += 1
      case 2 => if (!B.union(e(1) - 1, e(2) - 1)) remove += 1
      case _ =>
    })
    if (A.cnt == 1 && B.cnt == 1) return remove
    -1
  }

}
