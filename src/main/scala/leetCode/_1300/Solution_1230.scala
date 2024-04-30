package leetCode._1300

object Solution_1230 {
  def probabilityOfHeads(prob: Array[Double], target: Int): Double = {
    var dp = new Array[Double](target + 2)
    dp(0) = 1 - prob.head
    dp(1) = prob.head
    prob.indices.drop(1).foreach(i => {
      val tp = new Array[Double](target + 1)
      (0 to (i + 1).min(target)).foreach(j => {
        tp(j) = dp(j) * (1 - prob(i))
        if (j != 0) tp(j) += dp(j - 1) * prob(i)
      })
      dp = tp
    })
    dp(target)
  }
}
