package leetCode._1300

object Solution_1243 {
  def transformArray(arr: Array[Int]): List[Int] = {
    var flag = true
    while (flag) {
      flag = false
      val curr = arr.clone()
      curr.indices.drop(1).dropRight(1).foreach(i => if (curr(i) > curr(i - 1) && curr(i) > arr(i + 1)) {
        arr(i) -= 1
        flag = true
      } else if (curr(i) < curr(i - 1) && curr(i) < arr(i + 1)) {
        arr(i) += 1
        flag = true
      })
    }
    arr.toList
  }
}
