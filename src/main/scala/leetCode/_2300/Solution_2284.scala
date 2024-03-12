package leetCode._2300

object Solution_2284 {
  def largestWordCount(messages: Array[String], senders: Array[String]): String = senders
    .zip(messages)
    .groupBy(_._1)
    .toList
    .map { case (sender, tupledMsgs) =>
      val wordCount = tupledMsgs.map(_._2.count(_ == ' ') + 1)
      wordCount.sum -> sender
    }
    .max
    ._2
}
