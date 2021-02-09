package leetCode

object Solution_1333 {
  def filterRestaurants(restaurants: Array[Array[Int]], veganFriendly: Int, maxPrice: Int, maxDistance: Int): List[Int] = restaurants
    .filter(r => (veganFriendly == 0 || r(2) == 1) && r(3) <= maxPrice && r(4) <= maxDistance)
    .sortBy(r => (-r(1), -r.head))
    .map(_.head)
    .toList
}
