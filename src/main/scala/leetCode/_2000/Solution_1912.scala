package leetCode._2000

import scala.collection.mutable

object Solution_1912 {
  class MovieRentingSystem(n: Int, entries: Array[Array[Int]]) {

    import MovieRentingSystem._

    private val price = entries
      .collect { case Array(shopId, movieId, price) => ShopAndMovie(shopId, movieId) -> price }
      .toMap

    private implicit val ordering: Ordering[ShopAndMovie] = Ordering.by {
      shopAndMovie => (price(shopAndMovie), shopAndMovie.shop.id, shopAndMovie.movie.id)
    }

    private val unrented: mutable.Map[Movie, mutable.SortedSet[ShopAndMovie]] = mutable
      .Map(price.keys.toSeq.groupBy(_.movie).mapValues(mutable.SortedSet(_: _*)).toSeq: _*)
      .withDefaultValue(mutable.SortedSet())

    private val rented = mutable.SortedSet[ShopAndMovie]()

    def search(movie: Int): List[Int] = unrented(Movie(movie)).take(5).toList.map(_.shop.id)

    def rent(shopId: Int, movieId: Int): Unit = {
      val shopAndMovie = ShopAndMovie(shopId, movieId)
      unrented(shopAndMovie.movie) -= shopAndMovie
      rented += shopAndMovie
    }

    def drop(shopId: Int, movieId: Int): Unit = {
      val shopAndMovie = ShopAndMovie(shopId, movieId)
      unrented(shopAndMovie.movie) += shopAndMovie
      rented -= shopAndMovie
    }

    def report(): List[List[Int]] = rented.take(5).toList.map(_.toList)
  }

  private object MovieRentingSystem {
    private case class Shop(id: Int)

    private case class Movie(id: Int)

    private case class ShopAndMovie(shop: Shop, movie: Movie) {
      def toList: List[Int] = List(shop.id, movie.id)
    }

    private object ShopAndMovie {
      def apply(shopId: Int, movieId: Int): ShopAndMovie = ShopAndMovie(Shop(shopId), Movie(movieId))
    }
  }
}
