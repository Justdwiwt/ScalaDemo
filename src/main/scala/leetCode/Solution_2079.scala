package leetCode

object Solution_2079 {
  def wateringPlants(plants: Array[Int], cap: Int): Int = {
    var cur = cap
    plants.indices.map(i => {
      val t = if (cur >= plants(i)) {
        cur -= plants(i)
        1
      } else {
        cur = cap - plants(i)
        2 * i + 1
      }
      t
    }).sum
  }
}
