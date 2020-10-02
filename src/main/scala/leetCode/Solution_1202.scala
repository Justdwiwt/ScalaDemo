package leetCode

import scala.collection.mutable

object Solution_1202 {
  def smallestStringWithSwaps(s: String, pairs: List[List[Int]]): String = {
    class Uf(_n: Int) {
      val n: Int = _n
      val parent: Array[Int] = (0 until n).toArray

      def findParent(x: Int): Int = {
        if (this.parent(x) == x) return x
        findParent(this.parent(x))
      }

      def union(x: Int, y: Int): Unit = {
        if (findParent(x) == findParent(y)) return
        val p = findParent(x).min(findParent(y))
        this.parent(findParent(x)) = p
        this.parent(findParent(y)) = p
      }

      def toM: mutable.Map[Int, mutable.Set[Int]] = {
        val map = mutable.Map[Int, mutable.Set[Int]]()
        (0 until n).withFilter(i => findParent(i) == i).foreach(i => map += i -> mutable.Set[Int](i))
        (0 until n).withFilter(i => findParent(i) != i).foreach(i => map(findParent(i)).add(i))
        map
      }
    }

    val uf = new Uf(s.length)
    pairs.foreach(u => uf.union(u.head, u(1)))
    val m = mutable.Map[Int, Char]()
    val cluster = uf.toM
    cluster.keySet.foreach(key => {
      var idx = cluster(key).toArray
      val chars = idx.map(s.charAt).sortWith(_ < _)
      idx = idx.sortWith(_ < _)
      idx.indices.foreach(i => m += idx(i) -> chars(i))
    })
    (0 until s.length).map(m(_)).mkString
  }
}
