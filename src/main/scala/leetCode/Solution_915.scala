package leetCode

object Solution_915 {
  def partitionDisjoint(A: Array[Int]): Int = {
    var res = 0
    var pMax = A.head
    var cur = pMax
    A.indices.drop(1).foreach(i => {
      cur = cur.max(A(i))
      if (A(i) < pMax) {
        pMax = cur
        res = i
      }
    })
    res + 1
  }
}
