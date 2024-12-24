package leetCode._3400

object Solution_3389 {
  def makeStringGood(s: String): Int = {
    val cnt = s.groupBy(identity).mapValues(_.length).withDefaultValue(0)
    val m = cnt.values.max
    val maxIndex = 25

    def calcOp(x: Int, target: Int): Int = x.min((x - target).abs)

    @scala.annotation.tailrec
    def minOperations(target: Int, index: Int, f: Map[Int, Int]): Int =
      if (index < 0) f(0)
      else {
        val x = cnt((index + 'a').toChar)
        val y = cnt((index + 1 + 'a').toChar)
        val baseOp = calcOp(x, target) + calcOp(y, target)
        val mn = if (y < target) {
          val additional = if (x > target) (x - target).max(target - y) else x.max(target - y)
          baseOp.min(additional)
        } else baseOp
        val newF = f.updated(index, (f(index + 1) + calcOp(x, target)).min(f.getOrElse(index + 2, Int.MaxValue) + mn))
        minOperations(target, index - 1, newF)
      }

    (0 to m).foldLeft(s.length)((res, target) => {
      val f = Map(maxIndex -> calcOp(cnt((maxIndex + 'a').toChar), target), maxIndex + 1 -> 0).withDefaultValue(Int.MaxValue)
      res.min(minOperations(target, maxIndex - 1, f))
    })
  }
}
