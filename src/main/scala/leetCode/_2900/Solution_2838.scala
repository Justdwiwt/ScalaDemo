package leetCode._2900

import scala.collection.Searching._

object Solution_2838 {
  def maximumCoins(heroes: Array[Int], monsters: Array[Int], coins: Array[Int]): Array[Long] = {
    val sorted = monsters.zip(coins).sortBy(_._1)
    val ms = (Array((0, BigInt(0))) ++ sorted.map { case (m, c) => (m, BigInt(c)) }).scanLeft((0, BigInt(0))) { case ((_, acc), (m, c)) => (m, acc + c) }.tail
    heroes.map(h => ms(ms.search((h + 1, BigInt(-1))).insertionPoint - 1)._2.toLong)
  }
}
