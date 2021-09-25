package leetCode

object Solution_2008 {
  case class Passanger(from: Int, to: Int, tip: Int) {
    def cost: Long = to - from + tip
  }

  def maxTaxiEarnings(n: Int, rides: Array[Array[Int]]): Long = {
    val dp = Array.fill(n + 1)(0L)
    val pass = rides.toList.map(r => Passanger(r.head, r(1), r(2))).groupBy(_.to)

    dp.indices.drop(1).foreach(i => {
      val taken = pass.getOrElse(i, Nil).map(p => dp(p.from) + p.cost)
      dp(i) = (dp(i - 1) :: taken).max
    })

    dp.last
  }
}
