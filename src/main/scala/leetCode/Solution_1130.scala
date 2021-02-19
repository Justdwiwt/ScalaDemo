package leetCode

object Solution_1130 {

  case class SumAcc(preMx: Int, sum: Int)

  case class MctState(preV: List[Int], sum: Int) {
    def calMc(list: List[Int]): SumAcc = list match {
      case Nil => SumAcc(0, 0)
      case head :: tail => tail./:(SumAcc(head, 0))((acc, preV) => SumAcc(preV, acc.sum + acc.preMx * preV))
    }

    def nextState(value: Int): MctState = {
      val span = preV.span(_ <= value)
      val mc = calMc(span._1)
      MctState(value :: span._2, sum + mc.sum + mc.preMx * value)
    }

    def finalState(): MctState = {
      val mc = calMc(preV)
      MctState(Nil, sum + mc.sum)
    }
  }

  def mctFromLeafValues(arr: Array[Int]): Int =
    arr./:(MctState(Nil, 0))(_.nextState(_)).finalState().sum

}
