package leetCode._800

object Solution_787 {
  def findCheapestPrice(n: Int, flights: Array[Array[Int]], src: Int, dst: Int, k: Int): Int = {
    val arr = Array.fill(n)(Option.empty[Int])
    arr(src) = Some(0)
    (0 to k).foreach(_ => {
      val tmp = arr.clone()
      flights.foreach { case Array(from, to, price) =>
        arr(from) match {
          case Some(priceToSrc) if priceToSrc + price < tmp(to).getOrElse(Int.MaxValue) => tmp(to) = Some(priceToSrc + price)
          case _ =>
        }
      }
      (0 until n).foreach(i => arr(i) = tmp(i))
    })
    arr(dst).getOrElse(-1)
  }
}
