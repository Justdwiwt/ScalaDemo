package leetCode._700

object Solution_624 {
  def maxDistance(arrays: List[List[Int]]): Int = {
    var mx = arrays.head.last
    var mn = arrays.head.head
    var res = 0
    arrays.indices.drop(1).foreach(i => {
      res = res.max((arrays(i).head - mx).abs)
      res = res.max((arrays(i).last - mn).abs)
      mx = mx.max(arrays(i).last)
      mn = mn.min(arrays(i).head)
    })
    res
  }
}
