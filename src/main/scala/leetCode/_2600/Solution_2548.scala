package leetCode._2600

object Solution_2548 {
  def maxPrice(items: Array[Array[Int]], capacity: Int): Double = {
    val sorted = items.sortBy(x => x(1).toDouble / x.head)
    var price = 0.0
    var remainingCapacity = capacity.toDouble
    var res = -1.0
    sorted
      .withFilter(_ => res == -1.0)
      .foreach(x => {
        val p = x.head
        val c = x(1)
        if (c >= remainingCapacity) res = price + p * remainingCapacity / c
        else {
          price += p
          remainingCapacity -= c
        }
      })
    res
  }
}
