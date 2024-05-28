package leetCode._2300

import scala.collection.mutable

object Solution_2254 {

  class VideoSharingPlatform {
    private val heap: mutable.PriorityQueue[Int] = mutable.PriorityQueue.empty[Int](Ordering[Int].reverse)

    private val strToId: mutable.HashMap[String, Int] = mutable.HashMap.empty[String, Int]
    private val idToStr: mutable.HashMap[Int, String] = mutable.HashMap.empty[Int, String]
    private val likes: mutable.HashMap[Int, Int] = mutable.HashMap.empty[Int, Int]
    private val dislikes: mutable.HashMap[Int, Int] = mutable.HashMap.empty[Int, Int]
    private val views: mutable.HashMap[Int, Int] = mutable.HashMap.empty[Int, Int]

    (0 until 100005).foreach(heap.enqueue(_))

    def upload(video: String): Int = {
      val id = heap.dequeue()
      strToId.put(video, id)
      idToStr.put(id, video)
      likes.put(id, 0)
      dislikes.put(id, 0)
      views.put(id, 0)
      id
    }

    def remove(videoId: Int): Unit = {
      if (!idToStr.contains(videoId)) return
      val video = idToStr(videoId)
      idToStr.remove(videoId)
      strToId.remove(video)
      likes.remove(videoId)
      dislikes.remove(videoId)
      views.remove(videoId)
      heap.enqueue(videoId)
    }

    def watch(videoId: Int, startMinute: Int, endMinute: Int): String = {
      if (!idToStr.contains(videoId)) return "-1"
      val video = idToStr(videoId)
      views(videoId) += 1
      video.substring(startMinute, Math.min(endMinute + 1, video.length))
    }

    def like(videoId: Int): Unit =
      if (idToStr.contains(videoId)) likes(videoId) += 1

    def dislike(videoId: Int): Unit =
      if (idToStr.contains(videoId)) dislikes(videoId) += 1

    def getLikesAndDislikes(videoId: Int): Array[Int] =
      if (idToStr.contains(videoId)) Array(likes(videoId), dislikes(videoId))
      else Array(-1)

    def getViews(videoId: Int): Int =
      if (idToStr.contains(videoId)) views(videoId)
      else -1
  }

}
