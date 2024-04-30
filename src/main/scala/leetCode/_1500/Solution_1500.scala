package leetCode._1500

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Solution_1500 {
  class FileSharing(m: Int) {
    private var id = 1
    private val chunkUserMap = mutable.HashMap.empty[Int, ListBuffer[Int]]
    private val userChunkMap = mutable.HashMap.empty[Int, List[Int]]
    private val revokeIdQueue = new java.util.PriorityQueue[Int]()

    (1 to m).foreach(chunkUserMap.put(_, ListBuffer()))

    def join(ownedChunks: List[Int]): Int = {
      var idToAssign = id
      if (!revokeIdQueue.isEmpty) idToAssign = revokeIdQueue.poll()
      else id += 1
      userChunkMap.put(idToAssign, ownedChunks)
      ownedChunks.foreach(chunkUserMap(_) += idToAssign)
      idToAssign
    }

    def leave(userID: Int): Unit = {
      revokeIdQueue.add(userID)
      userChunkMap(userID).foreach(chunkUserMap(_) -= userID)
      userChunkMap.remove(userID)
    }

    def request(userID: Int, chunkID: Int): List[Int] = {
      val resList = chunkUserMap(chunkID).toList.sorted
      if (resList.nonEmpty && !resList.contains(userID)) {
        userChunkMap(userID) :+= chunkID
        chunkUserMap(chunkID) :+= userID
      }
      resList
    }
  }
}
