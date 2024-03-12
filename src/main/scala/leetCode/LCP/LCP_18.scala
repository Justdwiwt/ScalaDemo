package leetCode.LCP

object LCP_18 {
  def breakfastNumber(staple: Array[Int], drinks: Array[Int], x: Int): Int = {
    val sortedStaple = staple.sorted
    val sortedDrinks = drinks.sorted
    var r = sortedDrinks.length - 1
    val M = (1e9 + 7).toInt
    var res = 0
    sortedStaple.indices.foreach(i => {
      while (r >= 0 && sortedDrinks(r) + sortedStaple(i) > x) r -= 1
      res = (res + r + 1) % M
    })
    res
  }
}
