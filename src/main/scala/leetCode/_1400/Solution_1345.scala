package leetCode._1400

object Solution_1345 {
  def minJumps(arr: Array[Int]): Int = {
    val initVal2ind = arr.zipWithIndex.groupBy(_._1).mapValues(_.map(_._2).toSet).withDefaultValue(Set())

    @scala.annotation.tailrec
    def bfs(front: Set[Int], vis: Set[Int], dis: Int, val2ind: Map[Int, Set[Int]]): Int = {
      if (front.contains(arr.length - 1)) dis
      else {
        val next = front.flatMap(x => (val2ind(arr(x)) + (x + 1) + (x - 1)).filter(x => x >= 0 && x < arr.length && !vis.contains(x)))
        val newVal2ind = front./:(val2ind)((v, x) => v + (arr(x) -> Set()))
        bfs(next, vis ++ next, dis + 1, newVal2ind)
      }
    }

    bfs(Set(0), Set(0), 0, initVal2ind)
  }
}
