package leetCode

import scala.collection.mutable

object Solution_39 {
  def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
    if (candidates.length <= 0 || target < 0) return Nil
    dfs(candidates.sorted.reverse, target, 0, mutable.Stack[Int](), List[List[Int]]())
  }

  //noinspection ScalaDeprecation
  def dfs(candidates: Array[Int], target: Int, start: Int, path: mutable.Stack[Int], res: List[List[Int]]): List[List[Int]] = {
    if (target == 0) return path.toList :: res
    if (target < 0) return Nil
    var tmp = res
    (start until candidates.length).withFilter(i =>
      target >= candidates(i)).foreach(i => {
      path.push(candidates(i))
      tmp = dfs(candidates, target - candidates(i), i, path, res) ::: tmp
      path.pop()
    })
    tmp
  }
}
