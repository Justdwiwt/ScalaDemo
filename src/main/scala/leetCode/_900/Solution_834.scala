package leetCode._900

import scala.language.postfixOps

object Solution_834 {
  def sumOfDistancesInTree(N: Int, edges: Array[Array[Int]]): Array[Int] = {
    val graph = Array.fill(N)(Seq.empty[Int])
    edges.foreach(e => {
      graph(e.head) :+= e.last
      graph(e.last) :+= e.head
    })
    val (levels, parents) = scanTree(Seq(0), graph, Nil, Array.fill(N)(0))
    val subtrees = getSubtrees(levels, parents, Array.fill(N)((0, 0)))
    getSums(Seq(0), graph, subtrees, subtrees(0)._2 +: Array.fill(N - 1)(0))
  }

  @scala.annotation.tailrec
  def scanTree(q: Seq[Int], edges: Array[Seq[Int]], levels: Seq[Seq[Int]], parents: Array[Int]): (Seq[Seq[Int]], Array[Int]) = q match {
    case Seq() => (levels, parents)
    case _ =>
      scanTree(q.flatMap({ p => edges(p).filter(parents(p) !=).map({ c => parents(c) = p; c; }) }), edges, levels :+ q, parents)
  }

  @scala.annotation.tailrec
  def getSubtrees(levels: Seq[Seq[Int]], parents: Array[Int], res: Array[(Int, Int)]): Array[(Int, Int)] = levels match {
    case Seq(_) =>
      res(0) = (res(0)._1 + 1, res(0)._2)
      res
    case init :+ last =>
      last.foreach(c => {
        res(c) = (res(c)._1 + 1, res(c)._2)
        val old = res(parents(c))
        res(parents(c)) = (old._1 + res(c)._1, old._2 + res(c)._1 + res(c)._2)
      })
      getSubtrees(init, parents, res)
  }

  @scala.annotation.tailrec
  def getSums(q: Seq[Int], edges: Array[Seq[Int]], subtrees: Array[(Int, Int)], res: Array[Int]): Array[Int] = q match {
    case Seq() => res
    case _ => getSums(q.flatMap({ p => edges(p).filter(res(_) == 0).map({ c => res(c) = res(p) + res.length - subtrees(c)._1 * 2; c; }) }), edges, subtrees, res)
  }
}
