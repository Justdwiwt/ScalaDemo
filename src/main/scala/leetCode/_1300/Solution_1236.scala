package leetCode._1300

import scala.collection.mutable

object Solution_1236 {
  class HtmlParser {
    def getUrls(url: String): List[String] = ???
  }

  def crawl(startUrl: String, htmlParser: HtmlParser): Array[String] = {
    val res = mutable.ListBuffer.empty[String]
    val urls = mutable.HashSet.empty[String]
    val startHostName = getHostName(startUrl)
    val qu = mutable.Queue(startUrl)

    while (qu.nonEmpty) {
      val addr = qu.dequeue()
      res += addr
      urls += addr
      htmlParser.getUrls(addr).foreach(url => if (!urls.contains(url) && startHostName == getHostName(url)) {
        qu.enqueue(url)
        urls += url
      })
    }

    res.toArray
  }

  private def getHostName(startUrl: String): String = {
    val begin = startUrl.indexOf("//")
    val end = startUrl.indexOf("/", begin + 2)
    startUrl.substring(begin + 2, if (end == -1) startUrl.length else end)
  }
}
