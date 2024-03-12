package leetCode._2400

import scala.collection.mutable

object Solution_2353 {
  class FoodRatings(_foods: Array[String], _cuisines: Array[String], _ratings: Array[Int]) {

    private implicit val stringOrder: Ordering[String] = Ordering.String.reverse

    private val foodMap = mutable.Map.empty[String, (String, Int)]

    private val cuisineMap = mutable.Map.empty[String, mutable.TreeSet[(Int, String)]]

    _foods.zip(_cuisines).zip(_ratings).foreach { case ((food, cuisine), rating) =>
      foodMap(food) = (cuisine, rating)
      val set = cuisineMap.getOrElse(cuisine, upd(cuisine))
      set += ((rating, food))
    }

    def changeRating(food: String, newRating: Int): Unit = {
      val (cuisine, rating) = foodMap(food)
      foodMap(food) = (cuisine, newRating)
      val m = cuisineMap(cuisine)
      m -= ((rating, food))
      m += ((newRating, food))
    }

    def highestRated(cuisine: String): String =
      cuisineMap(cuisine).max._2

    private def upd(cuisine: String): mutable.TreeSet[(Int, String)] = {
      val s = mutable.TreeSet.empty[(Int, String)]
      cuisineMap(cuisine) = s
      s
    }
  }
}
