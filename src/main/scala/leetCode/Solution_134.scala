package leetCode

object Solution_134 {
  def canCompleteCircuit(gas: Array[Int], cost: Array[Int]): Int = {
    val g = gas.indices.map(x => gas(x) - cost(x))
    if (g.sum < 0) return -1
    var t = 0
    var start = 0
    g.indices.foreach(i => {
      t += g(i)
      if (t < 0) {
        start = i + 1
        t = 0
      }
    })
    start
  }
}
