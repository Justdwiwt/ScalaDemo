package leetCode

object Solution_452 {
  def findMinArrowShots(points: Array[Array[Int]]): Int = {
    if (points.isEmpty) return 0
    val p = points.sorted((o1: Array[Int], o2: Array[Int]) => o1(1) - o2(1))
    var res = 1
    var t = p(0)(1)
    (1 until p.length).foreach(i => {
      if (t < p(i)(0)) {
        res += 1
        t = p(i)(1)
      }
    })
    res
  }
}
