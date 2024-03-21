package leetCode._2000

object Solution_1981 {
  def minimizeTheDifference(mat: Array[Array[Int]], target: Int): Int = {
    var arr = Array.ofDim[Boolean](5000)
    arr(0) = true
    mat.foreach(row => {
      val next = Array.ofDim[Boolean](5000)
      arr
        .indices
        .withFilter(arr(_))
        .foreach(value => row.foreach(num => next(num + value) = true))
      arr = next
    })
    arr
      .indices
      .filter(arr(_))
      .map(num => (num - target).abs)
      .min
  }
}
