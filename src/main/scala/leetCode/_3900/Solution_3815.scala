package leetCode._3900

import scala.collection.mutable

object Solution_3815 {
  class AuctionSystem {

    private val userBids = mutable.HashMap[Int, mutable.HashMap[Int, Int]]()

    private val sortedBids = mutable.HashMap[Int, mutable.TreeSet[(Int, Int)]]()

    private implicit val bidOrdering: Ordering[(Int, Int)] =
      Ordering.fromLessThan((a, b) => {
        if (a._1 != b._1) a._1 > b._1
        else a._2 > b._2
      })

    def addBid(userId: Int, itemId: Int, bidAmount: Int): Unit = {
      val uMap = userBids.getOrElseUpdate(itemId, mutable.HashMap())
      val sSet = sortedBids.getOrElseUpdate(itemId, mutable.TreeSet())

      uMap.get(userId).foreach(oldBid => sSet.remove((oldBid, userId)))

      uMap(userId) = bidAmount
      sSet.add((bidAmount, userId))
    }

    def updateBid(userId: Int, itemId: Int, newAmount: Int): Unit = {
      val oldAmount = userBids(itemId)(userId)
      userBids(itemId)(userId) = newAmount

      val sSet = sortedBids(itemId)
      sSet.remove((oldAmount, userId))
      sSet.add((newAmount, userId))
    }

    def removeBid(userId: Int, itemId: Int): Unit = {
      val bidAmount = userBids(itemId)(userId)
      userBids(itemId).remove(userId)
      sortedBids(itemId).remove((bidAmount, userId))

      if (userBids(itemId).isEmpty) {
        userBids.remove(itemId)
        sortedBids.remove(itemId)
      }
    }

    def getHighestBidder(itemId: Int): Int = sortedBids.get(itemId) match {
      case None => -1
      case Some(set) => set.head._2
    }
  }
}
