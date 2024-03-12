package leetCode._2300

object Solution_2241 {
  class ATM() {

    private val banknotes = Array(20, 50, 100, 200, 500)
    private val arrIndices = (0 to 4).toArray
    private val reversedIndices = 4 to(0, -1)

    private var content = Array(0L, 0L, 0L, 0L, 0L)

    def deposit(banknotesCount: Array[Int]): Unit =
      content = arrIndices.map(i => content(i) + banknotesCount(i))

    def withdraw(amount: Int): Array[Int] = f(content, amount) match {
      case None => Array(-1)
      case Some(remain) =>
        val previous = content
        content = remain
        arrIndices.map(i => previous(i) - remain(i)).map(_.toInt)
    }

    def f(remain: Array[Long], amount: Long): Option[Array[Long]] =
      if (amount == 0) Some(remain)
      else reversedIndices.find(i => remain(i) > 0 && amount >= banknotes(i)).flatMap(i => {
        val cnt = remain(i).min(amount / banknotes(i))
        val next = remain.updated(i, remain(i) - cnt)
        f(next, amount - cnt * banknotes(i))
      })
  }
}
