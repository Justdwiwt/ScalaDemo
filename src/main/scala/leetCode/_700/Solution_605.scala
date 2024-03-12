package leetCode._700

object Solution_605 {
  def canPlaceFlowers(flowerbed: Array[Int], n: Int): Boolean =
    (-2 +: flowerbed.indices.filter(flowerbed.andThen(_ == 1)) :+ flowerbed.length + 1)
      .sliding(2)
      .map({ case Seq(s, e) => e - s - 1 })
      .map(x => x / 2 - ((x % 2) ^ 1))
      .sum >= n
}
