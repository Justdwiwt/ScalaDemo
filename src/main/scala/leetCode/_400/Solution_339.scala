package leetCode._400

object Solution_339 {
  def depthSum(nestedList: List[NestedInteger]): Int = {
    def f(nestedList: List[NestedInteger], level: Int): Int = nestedList.foldLeft(0)((acc, ni) => {
      if (ni.isInteger) acc + level * ni.getInteger
      else acc + f(ni.getList, level + 1)
    })

    f(nestedList, 1)
  }
}
