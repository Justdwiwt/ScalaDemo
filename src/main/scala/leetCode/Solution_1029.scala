package leetCode

object Solution_1029 {
  def twoCitySchedCost(costs: Array[Array[Int]]): Int = {
    var res = 0
    var diff = Array.empty[Int]
    costs.indices.foreach(i => diff :+= (costs(i)(0) - costs(i)(1)))
    diff = diff.sorted
    diff.indices.foreach(i => {
      res += costs(i)(1)
      if (i < diff.length / 2) res += diff(i)
    })
    res
  }
}
