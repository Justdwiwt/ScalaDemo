package leetCode

object Solution_2201 {
  def digArtifacts(n: Int, artifacts: Array[Array[Int]], dig: Array[Array[Int]]): Int = {
    val st = dig.map(x => (x.head, x(1))).toSet
    artifacts.count(c => (c.head to c(2)).flatMap(r => (c(1) to c(3)).map(col => (r, col))).forall(st.contains))
  }
}
