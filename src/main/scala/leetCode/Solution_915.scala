package leetCode

object Solution_915 {
  def partitionDisjoint(A: Array[Int]): Int = {
    var res = 0
    var pMax = A(0)
    var cur = pMax
    (1 until A.length).foreach(i => {
      cur = cur.max(A(i))
      if (A(i) < pMax) {
        pMax = cur
        res = i
      }
    })
    res + 1
  }
}
