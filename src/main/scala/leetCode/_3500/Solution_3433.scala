package leetCode._3500

object Solution_3433 {
  def countMentions(numberOfUsers: Int, events: List[List[String]]): Array[Int] = {
    val MESSAGE = "MESSAGE"
    val ALL = "ALL"
    val HERE = "HERE"
    val OFFLINE_TIME = 60

    val sortedEvents = events.sortWith((a, b) => {
      val timeA = a(1).toInt
      val timeB = b(1).toInt
      if (timeA == timeB) b.head < a.head
      else timeA < timeB
    })

    def updateMentions(mentions: Array[Int], onlineTimes: Array[Int], timestamp: Int): Array[Int] = mentions
      .zipWithIndex
      .map { case (mention, i) => if (onlineTimes(i) <= timestamp) mention + 1 else mention }

    def processEvent(mentions: Array[Int], onlineTimes: Array[Int], event: List[String]): (Array[Int], Array[Int]) = {
      val eventType = event.head
      val timestamp = event(1).toInt
      val users = event(2)

      eventType match {
        case MESSAGE => users match {
          case ALL => (updateMentions(mentions, onlineTimes, Integer.MAX_VALUE), onlineTimes)
          case HERE => (updateMentions(mentions, onlineTimes, timestamp), onlineTimes)
          case _ =>
            val updatedMentions = users.split(" ").foldLeft(mentions)((updated, idStr) => {
              try {
                val id = idStr.substring(2).toInt
                updated.updated(id, updated(id) + 1)
              } catch {
                case _: NumberFormatException => updated
              }
            })
            (updatedMentions, onlineTimes)
        }
        case _ => try {
          val id = users.toInt
          val updatedOnlineTimes = onlineTimes.updated(id, timestamp + OFFLINE_TIME)
          (mentions, updatedOnlineTimes)
        } catch {
          case _: NumberFormatException => (mentions, onlineTimes)
        }
      }
    }

    val (finalMentions, _) = sortedEvents.foldLeft((Array.fill(numberOfUsers)(0), Array.fill(numberOfUsers)(0))) {
      case ((mentions, onlineTimes), event) => processEvent(mentions, onlineTimes, event)
    }

    finalMentions
  }
}
