package leetCode

object Solution_1444 {
  val M = 1000000007L

  def ways(pizza: Array[String], k: Int): Int = {
    val arr = Array.fill(pizza.length + 1, pizza(0).length + 1)(0)
    val dp = Array.fill(pizza.length + 1, pizza(0).length + 1, k)(0L)
    (1 to pizza.length).foreach(r => (1 to pizza(0).length).foreach(c => arr(r)(c) = arr(r - 1)(c) + arr(r)(c - 1) - arr(r - 1)(c - 1) + (if (pizza(pizza.length - r)(pizza(0).length - c) == 'A') 1 else 0)))
    (0 to pizza.length).foreach(r => (0 to pizza(0).length).foreach(c => dp(r)(c)(0) = if (arr(r)(c) > 0) 1 else 0))
    (1 until k).foreach(cuts => (1 to pizza.length).foreach(r => (1 to pizza(0).length).foreach(c => {
      (1 until r).withFilter(cr => arr(r)(c) - arr(r - cr)(c) > 0).foreach(cr => {
        dp(r)(c)(cuts) += dp(r - cr)(c)(cuts - 1)
        dp(r)(c)(cuts) %= M
      })
      (1 until c).withFilter(cc => arr(r)(c) - arr(r)(c - cc) > 0).foreach(cc => {
        dp(r)(c)(cuts) += dp(r)(c - cc)(cuts - 1)
        dp(r)(c)(cuts) %= M
      })
    })))
    (dp(pizza.length)(pizza(0).length)(k - 1) % M).toInt
  }
}
