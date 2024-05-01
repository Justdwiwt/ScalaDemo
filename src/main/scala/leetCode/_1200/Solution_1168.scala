package leetCode._1200

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Solution_1168 {
  def minCostToSupplyWater(n: Int, wells: Array[Int], pipes: Array[Array[Int]]): Int = {
    val edgesHeap = mutable.PriorityQueue.empty[(Int, Int)](Ordering.by((_: (Int, Int))._1).reverse)

    val graph: ListBuffer[ListBuffer[(Int, Int)]] = ListBuffer.fill(n + 1)(ListBuffer.empty)

    wells.indices.foreach(i => {
      val virtualEdge = (wells(i), i + 1)
      graph.head += virtualEdge
      edgesHeap.enqueue(virtualEdge)
    })

    pipes.foreach(pipe => {
      val house1 = pipe(0)
      val house2 = pipe(1)
      val cost = pipe(2)
      graph(house1) += ((cost, house2))
      graph(house2) += ((cost, house1))
    })

    val mstSet = mutable.HashSet(0)
    var totalCost = 0
    while (mstSet.size < n + 1) {
      val edge = edgesHeap.dequeue
      val (cost, nextHouse) = edge
      if (mstSet.contains(nextHouse)) ()
      else {
        mstSet += nextHouse
        totalCost += cost
        graph(nextHouse).foreach(nei => if (!mstSet.contains(nei._2)) edgesHeap.enqueue(nei))
      }
    }

    totalCost
  }
}
