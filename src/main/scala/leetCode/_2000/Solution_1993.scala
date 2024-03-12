package leetCode._2000

object Solution_1993 {
  class LockingTree(_parent: Array[Int]) {

    val m = scala.collection.mutable.Map.empty[Int, Int]

    val desc: Map[Int, Vector[Int]] = _parent
      .zipWithIndex
      .groupBy({ case (par, _) => par })
      .map { case (p, desc) => p -> desc.map(_._2).toVector }
      .withDefaultValue(Vector.empty)

    def noLockedAncestors(num: Int): Boolean = {
      val parent = _parent(num)
      if (m.contains(num)) false
      else if (parent == -1) true
      else noLockedAncestors(parent)
    }

    def anyLockedDescendent(num: Int): Boolean =
      desc(num).exists(n => m.contains(n) || anyLockedDescendent(n))

    def unlockDescendents(num: Int): Unit =
      desc(num).foreach(n => {
        m -= n
        unlockDescendents(n)
      })

    def lock(num: Int, user: Int): Boolean =
      if (m.contains(num)) false
      else {
        m(num) = user
        true
      }

    def unlock(num: Int, user: Int): Boolean =
      if (m.get(num).contains(user)) {
        m -= num
        true
      } else false

    def upgrade(num: Int, user: Int): Boolean =
      if (noLockedAncestors(num) && anyLockedDescendent(num)) {
        m(num) = user
        unlockDescendents(num)
        true
      } else false
  }
}
