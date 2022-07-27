package leetCode

object Solution_2079 {
  def wateringPlants(plants: Array[Int], capacity: Int): Int = plants
    .zip(Stream.from(1))
    ./:((capacity, 0))((acc, cur) => {
      if (cur._1 <= acc._1) (acc._1 - cur._1, acc._2 + 1)
      else (capacity - cur._1, acc._2 + (cur._2 - 1) * 2 + 1)
    })
    ._2
}
