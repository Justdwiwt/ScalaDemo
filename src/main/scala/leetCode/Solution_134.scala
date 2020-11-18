package leetCode

object Solution_134 {

  case class Acc(gasInTank: Int, minGas: Int, minGasIdx: Int, prevCost: Int)

  def canCompleteCircuit(gas: Array[Int], cost: Array[Int]): Int = {
    val pre = gas.zip(cost).zipWithIndex./:(Acc(0, 0, -1, 0))(step)
    val res = step(pre, ((0, 0), 0))
    if (res.gasInTank >= 0) res.minGasIdx else -1
  }

  def step(acc: Acc, next: ((Int, Int), Int)): Acc = next match {
    case ((nextGas, nextCost), idx) =>
      val tripGas = acc.gasInTank - acc.prevCost
      val newGas = tripGas + nextGas
      Acc(newGas, tripGas.min(acc.minGas), if (tripGas <= acc.minGas) idx else acc.minGasIdx, nextCost)
  }

}
