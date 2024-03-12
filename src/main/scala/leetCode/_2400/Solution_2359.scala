package leetCode._2400

object Solution_2359 {
  def closestMeetingNode(edges: Array[Int], node1: Int, node2: Int): Int = {
    val node1Map = Array.fill(edges.length)(edges.length)
    val node2Map = Array.fill(edges.length)(edges.length)
    var cnt = 0
    node1Map(node1) = 0
    var cur = edges(node1)
    while (cur != -1 && node1Map(cur) == edges.length) {
      cnt += 1
      node1Map(cur) = cnt
      cur = edges(cur)
    }
    node2Map(node2) = 0
    cur = edges(node2)
    cnt = 0
    while (cur != -1 && node2Map(cur) == edges.length) {
      cnt += 1
      node2Map(cur) = cnt
      cur = edges(cur)
    }
    var retDis = edges.length
    var ret = -1
    edges.indices.foreach(i => if (retDis > (node1Map(i) max node2Map(i))) {
      retDis = node1Map(i) max node2Map(i)
      ret = i
    })
    ret
  }
}
