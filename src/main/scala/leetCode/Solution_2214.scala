package leetCode

object Solution_2214 {
  def minimumHealth(damage: Array[Int], armor: Int): Long = {
    var sum = 0L
    var mx = 0
    damage.indices.foreach(i => {
      sum += damage(i)
      mx = mx.max(damage(i))
    })
    sum - mx + 1 + 0.max(mx - armor)
  }
}
