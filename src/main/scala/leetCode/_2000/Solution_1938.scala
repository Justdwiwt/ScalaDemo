package leetCode._2000

import scala.collection.mutable

object Solution_1938 {
  def maxGeneticDifference(parents: Array[Int], queries: Array[Array[Int]]): Array[Int] = {
    val tree = Array.fill(parents.length)(List[Int]())
    val map = Array.fill(parents.length)(List[Node]())

    val root = parents.indices.foldLeft(-1)((root, i) =>
      if (parents(i) == -1) i
      else {
        tree(parents(i)) = i :: tree(parents(i))
        root
      })

    queries.indices.foreach(i => map(queries(i).head) = Node(queries(i)(1), i) :: map(queries(i).head))

    val res = Array.ofDim[Int](queries.length)
    val trie = new Trie
    iterativeBuild(root, trie, tree, map, res)
    res
  }

  private def iterativeBuild(root: Int, trie: Trie, tree: Array[List[Int]], map: Array[List[Node]], res: Array[Int]): Unit = {
    val st = mutable.Stack[(Int, Boolean)]()
    st.push((root, false))

    while (st.nonEmpty) {
      val (node, processed) = st.pop()

      if (processed) trie.update(node, -1)
      else {
        st.push((node, true))
        trie.update(node, 1)
        map(node).foreach(query => res(query.idx) = trie.query(query.value))
        tree(node).foreach(child => st.push((child, false)))
      }
    }
  }

  private case class Node(value: Int, idx: Int)

  private class Trie {
    private var cnt = 0
    private val tries = Array.ofDim[Trie](2)
    private val BITS_LIMIT = 20

    def update(value: Int, num: Int): Unit = {
      @scala.annotation.tailrec
      def loop(node: Trie, bitIdx: Int): Unit =
        if (bitIdx >= 0) {
          val bit = (value >> bitIdx) & 1
          if (node.tries(bit) == null) node.tries(bit) = new Trie
          node.cnt += num
          loop(node.tries(bit), bitIdx - 1)
        } else node.cnt += num

      loop(this, BITS_LIMIT)
    }

    def query(value: Int): Int = {
      @scala.annotation.tailrec
      def loop(node: Trie, bitIdx: Int, acc: Int): Int =
        if (bitIdx < 0) acc
        else {
          val bit = (value >> bitIdx) & 1
          if (node.tries(bit ^ 1) != null && node.tries(bit ^ 1).cnt > 0)
            loop(node.tries(bit ^ 1), bitIdx - 1, acc | (1 << bitIdx))
          else loop(node.tries(bit), bitIdx - 1, acc)
        }

      loop(this, BITS_LIMIT, 0)
    }
  }
}
