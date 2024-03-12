package leetCode._1300

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Solution_1203 {
  def sortItems(n: Int, m: Int, group: Array[Int], beforeItems: List[List[Int]]): Array[Int] = {
    val lmp = mutable.Map[Int, ListBuffer[Int]]()
    val graph = mutable.Map[Int, mutable.Set[Int]]()
    val nodesInG = mutable.Set[Int]()
    val inDegree = Array.ofDim[Int](n)
    val groupGraph = mutable.Map[Int, mutable.Set[Int]]()
    val groupNodesInG = mutable.Set[Int]()
    val groupInDegree = Array.ofDim[Int](m + 1)
    (0 until n)
      .withFilter(i => beforeItems(i).nonEmpty)
      .foreach(i => beforeItems(i).foreach(prev => {
        if (!graph.contains(prev)) graph.put(prev, mutable.Set[Int]())
        graph(prev).add(i)
        inDegree(i) += 1
        nodesInG.add(prev)
        nodesInG.add(i)
        val prevGroupIndex = if (group(prev) == -1) m else group(prev)
        val nextGroupIndex = if (group(i) == -1) m else group(i)
        if (prevGroupIndex != nextGroupIndex) {
          if (!groupGraph.contains(prevGroupIndex)) groupGraph.put(prevGroupIndex, mutable.Set[Int]())
          if (groupGraph(prevGroupIndex).add(nextGroupIndex)) {
            groupNodesInG add prevGroupIndex
            groupNodesInG add nextGroupIndex
            groupInDegree(nextGroupIndex) += 1
          }
        }
      }))

    val queue = mutable.Queue[Int]()
    var isVisited = mutable.Set[Int]()
    (0 until n).withFilter(i => graph.contains(i) && (inDegree(i) | 0) == 0).foreach(i => queue.enqueue(i))
    while (queue.nonEmpty) {
      val curr = queue.dequeue()
      val k = if (group(curr) == -1) m else group(curr)
      isVisited.add(curr)
      if (!lmp.contains(k)) lmp.put(k, new ListBuffer[Int]())
      lmp(k).append(curr)
      if (graph.contains(curr)) {
        graph(curr).foreach(nb => {
          inDegree(nb) -= 1
          if ((inDegree(nb) | 0) == 0) queue.enqueue(nb)
        })
      }
    }
    if (isVisited.size != nodesInG.size) return Array()
    queue.clear()

    (0 until n)
      .withFilter(i => !isVisited.contains(i))
      .foreach(i => {
        val k = if (group(i) == -1) m else group(i)
        if (!lmp.contains(k)) lmp.put(k, new ListBuffer[Int]())
        lmp(k).append(i)
      })

    isVisited = new mutable.LinkedHashSet[Int]()
    (0 to m).withFilter(i => groupGraph.contains(i) && (groupInDegree(i) | 0) == 0).foreach(i => queue.enqueue(i))
    while (queue.nonEmpty) {
      val curr = queue.dequeue()
      isVisited.add(curr)
      if (groupGraph.contains(curr)) {
        groupGraph(curr).foreach(nb => {
          groupInDegree(nb) -= 1
          if ((groupInDegree(nb) | 0) == 0) queue.enqueue(nb)
        })
      }
    }
    if (isVisited.size != groupNodesInG.size) return Array()

    (0 to m).withFilter(i => !isVisited.contains(i)).foreach(i => isVisited.add(i))

    var index = 0
    isVisited
      .withFilter(k => lmp.contains(k))
      .foreach(k => lmp(k).foreach(a => {
        group(index) = a
        index += 1
      }))
    group
  }
}
