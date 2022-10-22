package leetCode

object Solution_1213 {
  def arraysIntersection(arr1: Array[Int], arr2: Array[Int], arr3: Array[Int]): List[Int] = {
    var arr = List.empty[Int]
    val t = Array.fill(2001)(0)
    arr1.indices.foreach(i => t(arr1(i)) += 1)
    arr2.indices.foreach(i => t(arr2(i)) += 1)
    arr3.indices.foreach(i => {
      t(arr3(i)) += 1
      if (t(arr3(i)) == 3) arr ::= arr3(i)
    })
    arr.reverse
  }
}
