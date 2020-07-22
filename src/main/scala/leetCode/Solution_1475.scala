package leetCode

object Solution_1475 {
  def finalPrices(prices: Array[Int]): Array[Int] = {
    @scala.annotation.tailrec
    def solve(l: List[Int], min_prices: List[Int] = Nil, acc: List[Int] = Nil): List[Int] = l match {
      case Nil => acc
      case h :: t =>
        min_prices.dropWhile(x => x > h) match {
          case Nil => solve(t, h :: Nil, h :: acc)
          case h0 :: t0 => solve(t, h :: h0 :: t0, (h - h0) :: acc)
        }
    }

    solve(prices.toList.reverse).toArray
  }
}
