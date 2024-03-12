package leetCode._1600

object Solution_1584 {

  case class Point(x: Int, y: Int) {
    def distanceFromOrigin: Int = x + y

    def distance(p: Point): Int = (p.y - y).abs + (p.x - x).abs
  }

  case class PointPair(a: Point, i: Int, b: Point, j: Int, distance: Int)

  object PointPair {
    implicit val ordering: Ordering[PointPair] = (pair1: PointPair, pair2: PointPair) => pair2.distance.compare(pair1.distance)
  }

  def minCostConnectPoints(_points: Array[Array[Int]]): Int = {
    val pq = new scala.collection.mutable.PriorityQueue[PointPair]()
    val points = _points.map(p => Point(p(0), p(1)))

    points.indices.foreach(i => (i + 1 until points.length).foreach(j => pq += PointPair(points(i), i, points(j), j, points(i).distance(points(j)))))

    val uf = new UnionFind(points.length + 1)
    var cost = 0
    var cnt = 0
    while (pq.nonEmpty && cnt < points.length - 1) {
      val PointPair(_, i, _, j, distance) = pq.dequeue
      if (!uf.sameElement(i, j)) {
        cost += distance
        cnt += 1
        uf.union(i, j)
      }
    }
    cost
  }
}

class UnionFind(n: Int) {

  case class Node(parent: Int, count: Int)

  private val arr = Array.tabulate(n)(x => Node(x, 1))

  def union(a: Int, b: Int): Unit = {
    val aRoot = find(a)
    val bRoot = find(b)
    if (aRoot != bRoot)
      if (aRoot.count > bRoot.count) {
        arr(aRoot.parent) = aRoot.copy(count = aRoot.count + bRoot.count)
        arr(bRoot.parent) = bRoot.copy(parent = aRoot.parent)
      } else {
        arr(bRoot.parent) = bRoot.copy(count = aRoot.count + bRoot.count)
        arr(aRoot.parent) = aRoot.copy(parent = bRoot.parent)
      }
  }

  def find(a: Int): Node = {
    var next = arr(a)
    while (next.parent != arr(next.parent).parent) next = arr(next.parent)
    next
  }

  def sameElement(a: Int, b: Int): Boolean = find(a).parent == find(b).parent

}
