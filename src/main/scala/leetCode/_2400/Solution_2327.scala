package leetCode._2400

object Solution_2327 {
  private val M = 1000000007

  private def sumMod(arr: Seq[Int]): Int =
    arr./:(0L)((sum, el) => (sum + M + el) % M).toInt

  def peopleAwareOfSecret(n: Int, delay: Int, forget: Int): Int = {
    val learners = Array.fill(n)(0)
    learners(0) = 1

    def getLearner(i: Int): Int =
      if (i < 0) 0
      else learners(i)

    (1 until n).foreach(i => {
      val window = (i - forget + 1).to(i - delay).map(getLearner)
      learners(i) = sumMod(window)
    })

    val awarePerDay = (0 until n).map(i => getLearner(i) - getLearner(i - forget))

    sumMod(awarePerDay)
  }
}
