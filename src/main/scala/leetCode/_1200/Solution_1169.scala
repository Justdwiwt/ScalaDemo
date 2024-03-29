package leetCode._1200

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Solution_1169 {
  private case class Transaction(name: String, time: Int, amount: Int, city: String) {
    override def toString: String = name + "," + time.toString + "," + amount.toString + "," + city
  }

  def invalidTransactions(transactions: Array[String]): List[String] = {
    val res = mutable.ListBuffer[String]()
    val m = mutable.HashMap.empty[String, ListBuffer[Transaction]]

    transactions.foreach(t => {
      val split = t.split(",")
      val transaction = Transaction(split(0), split(1).toInt, split(2).toInt, split(3))
      val transactionsForName = m.getOrElseUpdate(transaction.name, ListBuffer())
      transactionsForName += transaction
    })

    m.values.foreach(trans => trans
      .filter(cur => cur.amount > 1000 || trans.exists(t => t.city != cur.city && (t.time - cur.time).abs <= 60))
      .foreach(res += _.toString))

    res.toList
  }
}
