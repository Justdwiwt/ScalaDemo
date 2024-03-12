package leetCode._900

import scala.collection.mutable.ArrayBuffer

object Solution_821 {
  def shortestToChar(S: String, C: Char): Array[Int] = {
    val m = new ArrayBuffer[Int]()
    S.zipWithIndex.foreach(p => if (p._1 == C) m += p._2)
    S.zipWithIndex.map(p => m.map(i => (i - p._2).abs).min).toArray
  }
}
