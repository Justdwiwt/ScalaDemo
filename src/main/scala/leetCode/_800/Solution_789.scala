package leetCode._800

object Solution_789 {
  def escapeGhosts(ghosts: Array[Array[Int]], target: Array[Int]): Boolean =
    ghosts.forall(ghost => (ghost.head - target.head).abs + (ghost(1) - target(1)).abs > (target.head.abs + target(1).abs))
}
