package leetCode

object Solution_2105 {
  def minimumRefill(plants: Array[Int], capacityA: Int, capacityB: Int): Int = {
    var res = 0
    var i = 0
    var j = plants.length - 1
    var wa = capacityA
    var wb = capacityB
    while (i <= j) {
      if (i < j) {
        if (wa < plants(i)) {
          wa = capacityA
          res += 1
        }
        if (wb < plants(j)) {
          wb = capacityB
          res += 1
        }
      } else if (wa.max(wb) < plants(i)) res += 1
      wa -= plants(i)
      wb -= plants(j)
      i += 1
      j -= 1
    }
    res
  }
}
