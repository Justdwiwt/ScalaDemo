package leetCode

import scala.collection.mutable

object Solution_1203 {
  def sortItems(n: Int, m: Int, group: Array[Int], beforeItems: List[List[Int]]): Array[Int] = {
    def topologicalSort(graph: Map[Int, List[Int]], inDegrees: Array[Int]) = {
      val q = new mutable.Queue[Int]()
      graph.keys.withFilter(node => inDegrees(node) == 0).foreach(node => q += node)
      val res = new Array[Int](inDegrees.length)
      var i = 0
      var visCnt = 0
      while (q.nonEmpty) {
        val head = q.dequeue()
        res(i) = head
        visCnt += 1
        i += 1
        graph(head).foreach(child => {
          inDegrees(child) -= 1
          if (inDegrees(child) == 0) q += child
        })
      }

      if (visCnt != graph.keys.size) Array() else res
    }

    var groupToGroup = Map[Int, List[Int]]()
    var parentToChildren = Map[Int, List[Int]]()
    val groupInDegree = new Array[Int](m + 1)
    val nodeInDegree = new Array[Int](n)
    val beforeItemsArr = beforeItems.toArray
    group.indices.foreach(i => {
      if (group(i) == -1) group(i) = m
      parentToChildren += ((i, List()))
    })

    (0 to m).foreach(i => groupToGroup += ((i, List())))
    beforeItemsArr.indices.foreach(i => {
      val before = beforeItemsArr(i)
      before.foreach(b => {
        parentToChildren += ((b, parentToChildren.get(b).map(i :: _).getOrElse(List(i))))
        nodeInDegree(i) += 1
        val bGroup = group(b)
        val iGroup = group(i)
        if (bGroup != iGroup) {
          groupToGroup += ((bGroup, groupToGroup.get(bGroup).map(iGroup :: _).getOrElse(List(iGroup))))
          groupInDegree(iGroup) += 1
        }
      })
    })

    val parentToChildrenSorted = topologicalSort(parentToChildren, nodeInDegree)
    if (parentToChildrenSorted.isEmpty) return Array()
    val groupsSorted = topologicalSort(groupToGroup, groupInDegree)
    if (groupsSorted.isEmpty) return Array()

    var groupToItem = Map[Int, Vector[Int]]()
    parentToChildrenSorted.foreach(n => {
      val grp = group(n)
      groupToItem += ((grp, groupToItem.get(grp).map(_ :+ n).getOrElse(Vector(n))))
    })

    val result = new Array[Int](n)
    var i = 0
    groupsSorted.foreach(group => if (groupToItem.contains(group)) groupToItem(group).foreach(node => {
      result(i) = node
      i += 1
    }))

    result
  }
}
