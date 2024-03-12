package leetCode.LCP

object LCP_50 {
  def giveGem(gem: Array[Int], operations: Array[Array[Int]]): Int = {
    operations.foreach(o => {
      val half = gem(o.head) / 2
      gem(o.head) -= half
      gem(o(1)) += half
    })
    gem.max - gem.min
  }
}
