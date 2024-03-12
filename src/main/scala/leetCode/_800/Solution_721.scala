package leetCode._800

object Solution_721 {
  def accountsMerge(accounts: List[List[String]]): List[List[String]] = {
    class Acc(var _id: Int, val _name: String, var _emails: List[String])
    var accId = 0
    val accArr = accounts.toArray.map(x => {
      val acc = new Acc(accId, x.head, x.tail)
      accId += 1
      acc
    })
    var m = Map.empty[String, Acc]
    var res = List.empty[Acc]
    accArr.foreach(acc => {
      val toMerge = acc._emails.filter(e => m.contains(e)).map(e => m(e)).toSet
      if (toMerge.nonEmpty) {
        val merged = toMerge.reduce((a, b) => new Acc(a._id, b._name, a._emails ::: b._emails))
        merged._emails :::= acc._emails
        res = merged :: res.filterNot(toMerge)
        merged._emails.foreach(e => m += e -> merged)
      } else {
        res ::= acc
        acc._emails.foreach(e => m += e -> acc)
      }
    })
    res.map(acc => acc._name :: acc._emails.distinct.sorted)
  }
}
