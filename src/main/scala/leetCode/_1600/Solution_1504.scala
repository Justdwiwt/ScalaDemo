package leetCode._1600

object Solution_1504 {
  def numSubmat(mat: Array[Array[Int]]): Int = {
    mat.head.indices.foreach(j => mat
      .indices
      .drop(1)
      .withFilter(i => mat(i)(j) != 0)
      .foreach(i => mat(i)(j) += mat(i - 1)(j))
    )
    var res = 0
    mat.indices.foreach(i => mat(i).indices.foreach(j => {
      var mn = Integer.MAX_VALUE
      (j until mat(i).length).foreach(k => {
        mn = mn.min(mat(i)(k))
        res += mn
      })
    }))
    res
  }
}
