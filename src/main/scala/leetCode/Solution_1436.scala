package leetCode

object Solution_1436 {
  def destCity(paths: List[List[String]]): String = paths
    .map(_(1))
    .filter(ds => paths.forall(p => p.head != ds))
    .head
}
