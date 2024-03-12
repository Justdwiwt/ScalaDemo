package leetCode._600

object Solution_573 {
  def minDistance(height: Int, width: Int, tree: Array[Int], squirrel: Array[Int], nuts: Array[Array[Int]]): Int = {
    val distance = Array.fill(nuts.length)(0)
    var sum = 0
    nuts.indices.foreach(i => {
      distance(i) = (nuts(i).head - tree.head).abs + (nuts(i)(1) - tree(1)).abs
      sum += 2 * distance(i)
    })
    var res = sum - distance.head + (squirrel.head - nuts.head.head).abs + (squirrel(1) - nuts.head(1)).abs
    distance.indices.drop(1).foreach(i => {
      val t = sum - distance(i) + (squirrel.head - nuts(i).head).abs + (squirrel(1) - nuts(i)(1)).abs
      res = if (t < res) t else res
    })
    res
  }
}
