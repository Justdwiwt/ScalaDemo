package leetCode

object Code_16_16 {
  def subSort(array: Array[Int]): Array[Int] = {
    val t = array.sorted
    var l = -1
    var r = -1
    array.indices.foreach(i => {
      if (array(i) != t(i)) {
        if (l == -1) l = i
        r = i
      }
    })
    Array(l, r)
  }
}
