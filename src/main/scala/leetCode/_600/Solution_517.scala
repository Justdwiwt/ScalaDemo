package leetCode._600

object Solution_517 {
  def findMinMoves(machines: Array[Int]): Int = {
    val sum = machines.sum
    if (sum % machines.length != 0) return -1
    val target = sum / machines.length
    var res = 0
    var balance = 0
    machines.indices.foreach(i => {
      balance += machines(i) - target
      res = res.max((machines(i) - target).max(balance.abs))
    })
    res
  }
}
