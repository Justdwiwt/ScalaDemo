package leetCode

object Solution_332 {
  def findItinerary(tickets: List[List[String]]): List[String] = {
    def dropFirstWhere(l: List[String], e: String): List[String] = l match {
      case h :: t if h == e => t
      case h :: t => h :: dropFirstWhere(t, e)
    }

    val ticketMap = tickets./:(Map[String, List[String]]()) {
      case (m, ticket) if m.contains(ticket.head) => m.updated(ticket.head, ticket(1) :: m(ticket.head))
      case (m, ticket) => m.updated(ticket.head, List(ticket(1)))
    }.map({ case (s, q) => (s, q.sorted) })

    def f(str: String, cur: Map[String, List[String]], res: List[String]): Option[List[String]] =
      if (cur.isEmpty) Some(res)
      else if (!cur.contains(str) || cur(str).isEmpty) None
      else cur(str)./:(None: Option[List[String]]) {
        case (Some(x), _) => Some(x)
        case (None, newStr) =>
          val newTickets = if (cur(str).length == 1) cur - str else cur.updated(str, dropFirstWhere(cur(str), newStr))
          f(newStr, newTickets, newStr :: res)
      }

    f("JFK", ticketMap, List("JFK")).getOrElse(List("")).reverse
  }
}
