package leetCode._2200

import scala.collection.immutable.TreeSet
import scala.util.Try

object Solution_2192 {
  trait Monoid[A] {
    def op(a1: A, a2: A): A

    def zero: A
  }

  implicit final val TreeSetMonoid: Monoid[TreeSet[Int]] = new Monoid[TreeSet[Int]] {
    override final def op(i1: TreeSet[Int], i2: TreeSet[Int]): TreeSet[Int] = i1 ++ i2

    override final val zero: TreeSet[Int] = TreeSet.empty[Int]
  }

  implicit def mapMonoid[K, V](implicit V: Monoid[V]): Monoid[Map[K, V]] =
    new Monoid[Map[K, V]] {
      def zero: Map[K, V] = Map[K, V]().withDefaultValue(V.zero)

      def op(a: Map[K, V], b: Map[K, V]): Map[K, V] =
        (a.keySet ++ b.keySet).foldLeft(zero)((acc, k) => acc.updated(k, V.op(a.getOrElse(k, V.zero), b.getOrElse(k, V.zero))))
    }

  implicit class MonoidOps[A](private val a1: A) {
    def |+|(a2: A)(implicit M: Monoid[A]): A =
      M.op(a1, a2)
  }

  def getAncestors(n: Int, edges: Array[Array[Int]]): List[List[Int]] = {
    val adjList = edges.foldLeft(mapMonoid[Int, TreeSet[Int]].zero) { case (acc, Array(from, to)) => Map(to -> TreeSet(from)) |+| acc }

    val mem = scala.collection.mutable.Map.empty[Int, TreeSet[Int]]

    def dfs(node: Int): TreeSet[Int] = mem.getOrElseUpdate(node, {
      Try(adjList(node)).getOrElse(TreeSet.empty[Int]).flatMap(ancestor => dfs(ancestor) + ancestor)
    })

    (0 until n).map(dfs(_).toList).toList
  }
}
