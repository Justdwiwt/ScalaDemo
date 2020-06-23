package leetCode

object Solution_1052 {
  def maxSatisfied(customers: Array[Int], grumpy: Array[Int], X: Int): Int = {
    var sum = 0
    customers.indices.foreach(i => {
      if (grumpy(i) == 0) {
        sum += customers(i)
        customers(i) = 0
      }
    })
    var num = customers(0)
    var mx = customers(0)
    (1 until customers.length).foreach(i => {
      if (i < X) num += customers(i)
      else num += (customers(i) - customers(i - X))
      mx = mx.max(num)
    })
    sum + mx
  }
}
