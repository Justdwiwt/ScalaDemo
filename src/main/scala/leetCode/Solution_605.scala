package leetCode

object Solution_605 {
  def canPlaceFlowers(flowerbed: Array[Int], n: Int): Boolean = {
    var p = n
    flowerbed.indices.foreach(i => {
      if (p == 0) return true
      if (flowerbed(i) == 0) {
        val next = if (i == flowerbed.length - 1) 0 else flowerbed(i + 1)
        val pre = if (i == 0) 0 else flowerbed(i - 1)
        if (next + pre == 0) {
          flowerbed(i) = 1
          p -= 1
        }
      }
    })
    p <= 0
  }
}
