package leetCode._1500

object Solution_1489 {
  def findCriticalAndPseudoCriticalEdges(n: Int, edges: Array[Array[Int]]): List[List[Int]] = {
    var arr = Array.ofDim[Int](edges.length, 4)
    edges.indices.foreach(i => {
      arr(i)(0) = edges(i)(0)
      arr(i)(1) = edges(i)(1)
      arr(i)(2) = edges(i)(2)
      arr(i)(3) = i
    })
    arr = arr.sorted((o1: Array[Int], o2: Array[Int]) => o1(2) - o2(2))
    var realArr = Array.emptyIntArray
    var fakeArr = Array.emptyIntArray
    val minCost = getExclude(n, arr, -1)
    edges.indices.foreach(i => {
      if (getExclude(n, arr, i) > minCost) realArr :+= i
      else if (getInclude(n, arr, i) == minCost) fakeArr :+= i
    })
    var res = List.empty[List[Int]]
    res :+= realArr.toList
    res :+= fakeArr.toList
    res
  }

  def getExclude(n: Int, edges: Array[Array[Int]], edge: Int): Int = {
    val ends = Array.fill(n)(-1)
    var cost = 0
    var cnt = 0
    edges.withFilter(e => e(3) != edge).foreach(e => {
      val end1 = getEnd(ends, e(0))
      val end2 = getEnd(ends, e(1))
      if (end1 != end2) {
        ends(end1) = end2
        cost += e(2)
        cnt += 1
      }
    })
    if (cnt == n - 1) cost else Int.MaxValue
  }

  def getInclude(n: Int, edges: Array[Array[Int]], edge: Int): Int = {
    val ends = Array.fill(n)(-1)
    var cost = 0
    var cnt = 0
    edges.foreach(e => if (e(3) == edge) {
      ends(e(0)) = e(1)
      cost += e(2)
      cnt += 1
    })
    edges.foreach(e => {
      val end1 = getEnd(ends, e(0))
      val end2 = getEnd(ends, e(1))
      if (end1 != end2) {
        ends(end1) = end2
        cost += e(2)
        cnt += 1
      }
    })
    if (cnt == n - 1) cost else Int.MaxValue
  }

  def getEnd(ends: Array[Int], node: Int): Int =
    if (ends(node) == -1) node
    else {
      ends(node) = getEnd(ends, ends(node))
      ends(node)
    }
}
