package leetCode

object Solution_1665 {
  def minimumEffort(tasks: Array[Array[Int]]): Int = {
    var res = 0
    tasks.sortBy(t => t(1) - t(0)).withFilter({ case Array(_, _) => true; case _ => false }).foreach({ case Array(actual, initial) =>
      res += actual
      if (res < initial) res += initial - res
    })
    res
  }
}
