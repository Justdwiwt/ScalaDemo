package leetCode._400

object Solution_339 {
  def depthSum(nestedList: List[NestedInteger]): Int = {

    def f(nestedList: List[NestedInteger], depth: Int): Int = {
      var sum = 0
      nestedList.foreach(v => sum += (if (v.isInteger) v.getInteger * depth else f(v.getList, depth + 1)))
      sum
    }

    f(nestedList, 1)
  }
}
