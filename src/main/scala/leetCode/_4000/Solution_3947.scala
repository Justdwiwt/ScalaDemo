package leetCode._4000

object Solution_3947 {
  def maximumSaleItems(items: Array[Array[Int]], budget: Int): Int = {
    val n = items.length

    val cntFactor = Array.fill(n + 1)(0)

    val minPrice = items.map(x => {
      cntFactor(x(0)) += 1
      x(1)
    }).min

    val cntMulti = Array.fill(n + 1)(0)

    val sumCnt = collection.mutable.HashMap[Int, Long]()

    items.foreach { case Array(factor, price) =>
      if (price < minPrice * 2) {

        if (cntMulti(factor) == 0) (factor to n by factor).foreach(cntMulti(factor) += cntFactor(_))

        val cnt = cntMulti(factor) - 1

        if (cnt > 0) sumCnt(price) = sumCnt.getOrElse(price, 0L) + cnt
      }
    }

    var money = budget.toLong
    var ans = 0L

    sumCnt.toSeq.sortBy(_._1).foreach { case (price, cnt) =>
      val c = math.min(cnt, money / price)
      money -= price * c
      ans += c * 2
    }

    (ans + money / minPrice).toInt
  }
}
