package leetCode._2900

import scala.collection.Searching._

object Solution_2838 {
  // fixme: case 703/706 data limit exceeded
  def maximumCoins(heroes: Array[Int], monsters: Array[Int], coins: Array[Int]): Array[Long] = {
    val ms = (Array((0, 0)) ++ monsters.zip(coins).sorted).scanLeft((0, 0)) { case ((_, acc), (m, c)) => (m, acc + c) }.tail
    heroes.map(h => ms(ms.search((h + 1, -1)).insertionPoint - 1)._2).map(_.toLong)
  }
}
