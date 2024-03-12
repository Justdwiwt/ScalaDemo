package leetCode._100

object Solution_31 {
  case class SplitResult(init: List[Int], rest: List[Int])

  @scala.annotation.tailrec
  def splitAtReversal(prev: Int, rest: List[Int], acc: List[Int]): SplitResult =
    if (rest.isEmpty) SplitResult(rest, acc)
    else if (rest.head < prev) SplitResult(rest, acc :+ prev)
    else splitAtReversal(rest.head, rest.tail, acc :+ prev)

  case class ReversalResult(item: Int, list: List[Int])

  def getReversal(item: Int, list: List[Int]): ReversalResult = {
    val (replacement, replacementIndex) = list.zipWithIndex.filter { case (a, _) => a > item }.minBy { case (a, _) => a }
    ReversalResult(replacement, list.slice(0, replacementIndex) ::: List(item) ::: list.slice(replacementIndex + 1, list.length))
  }

  def nextPermutation(nums: Array[Int]): Unit = {
    val list = nums.toList.reverse
    val SplitResult(leadAndLast, toRev) = splitAtReversal(list.head, list.tail, List())
    val result = if (leadAndLast.isEmpty) list
    else {
      val itemToReplace = leadAndLast.reverse.last
      val constants = leadAndLast.reverse.init
      val ReversalResult(newItem, replaceList) = getReversal(itemToReplace, toRev)
      constants ::: List(newItem) ::: replaceList
    }
    result.indices.foreach(i => nums(i) = result(i))
  }
}
