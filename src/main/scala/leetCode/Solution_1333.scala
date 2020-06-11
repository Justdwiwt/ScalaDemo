package leetCode

object Solution_1333 {
  def filterRestaurants(restaurants: Array[Array[Int]], veganFriendly: Int, maxPrice: Int, maxDistance: Int): List[Int] = {
    restaurants.filter(r => (if (veganFriendly == 1) r(2) == veganFriendly else true) && r(4) <= maxDistance && r(3) <= maxPrice)
      .sorted((o1: Array[Int], o2: Array[Int]) => if (o1(1) != o2(1)) o2(1) - o1(1) else o2(0) - o1(0))
      .map(x => x(0)).toList
  }
}
