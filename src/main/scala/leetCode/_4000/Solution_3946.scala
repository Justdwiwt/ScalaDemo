package leetCode._4000

object Solution_3946 {
  def maximumSaleItems(items: Array[Array[Int]], budget: Int): Int = {
    val f = Array.fill(budget + 1)(0)
    val minPrice = items.map(_(1)).min

    items.foreach(item => {
      val factor = item.head
      val price = item(1)
      val cnt = items.count(_.head % factor == 0)

      (budget to price by -1).foreach(j => f(j) = f(j).max(f(j - price) + cnt))
    })

    (0 to budget)
      .map(i => f(i) + (budget - i) / minPrice)
      .max
  }
}
