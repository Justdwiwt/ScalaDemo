package leetCode._1700

object Solution_1648 {

  class Data(_value: Int, _count: Int = 1) {
    val v: Int = _value
    var count: Int = _count
  }

  def maxProfit(inventory: Array[Int], orders: Int): Int = {
    val pq = new java.util.PriorityQueue[Data]((a: Data, b: Data) => -Integer.compare(a.v, b.v))
    inventory.foreach(i => pq.offer(new Data(i)))
    var res: Long = 0
    val mod: Long = (math.pow(10, 9) + 7).toLong
    var oo = orders
    while (!pq.isEmpty && oo > 0) {
      val top = pq.poll()
      val cur = top.v
      var next = if (!pq.isEmpty) pq.peek().v else 0
      val count = top.count
      if ((cur - next) * count <= oo) {
        res = (res + ((next + 1 + cur).toLong * (cur - next).toLong * count / 2) % mod) % mod
        oo = oo - (cur - next) * count
        if (!pq.isEmpty) pq.peek().count = count + 1
      } else {
        next = cur - oo / count
        res = (res + ((next + 1 + cur).toLong * (cur - next).toLong * count / 2) % mod) % mod
        res = (res + next.toLong * (oo % count)) % mod
        oo = 0
      }
    }
    res.toInt
  }
}
