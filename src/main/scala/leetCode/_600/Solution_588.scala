package leetCode._600

import scala.collection.immutable.SortedMap

object Solution_588 {
  class FileSystem {
    private sealed trait Node {
      def isFile: Boolean
    }

    private case class FileNode(content: String) extends Node {
      val isFile: Boolean = true
    }

    private case class DirNode(files: SortedMap[String, Node] = SortedMap.empty) extends Node {
      val isFile: Boolean = false
    }

    private var root: DirNode = DirNode()

    def ls(path: String): List[String] = {
      @scala.annotation.tailrec
      def getNode(node: Node, parts: List[String]): Node = (node, parts) match {
        case (dir: DirNode, head :: tail) => getNode(dir.files(head), tail)
        case (n, Nil) => n
        case _ => throw new IllegalArgumentException("Invalid path")
      }

      val parts = path.split("/").filter(_.nonEmpty).toList
      getNode(root, parts) match {
        case FileNode(_) => List(parts.last)
        case DirNode(files) => files.keys.toList
      }
    }

    def mkdir(path: String): Unit = {
      def createDir(node: DirNode, parts: List[String]): DirNode = parts match {
        case head :: tail =>
          val nextNode = node.files.getOrElse(head, DirNode())
          val updatedNode = nextNode match {
            case dir: DirNode => createDir(dir, tail)
            case _ => throw new IllegalArgumentException("Invalid path")
          }
          node.copy(files = node.files.updated(head, updatedNode))
        case Nil => node
      }

      val parts = path.split("/").filter(_.nonEmpty).toList
      root = createDir(root, parts)
    }

    def addContentToFile(filePath: String, content: String): Unit = {
      def addContent(node: DirNode, parts: List[String]): DirNode = parts match {
        case head :: Nil =>
          val fileNode = node.files.get(head) match {
            case Some(FileNode(existingContent)) => FileNode(existingContent + content)
            case None => FileNode(content)
            case _ => throw new IllegalArgumentException("Invalid path")
          }
          node.copy(files = node.files.updated(head, fileNode))
        case head :: tail =>
          val nextNode = node.files.getOrElse(head, DirNode())
          val updatedNode = nextNode match {
            case dir: DirNode => addContent(dir, tail)
            case _ => throw new IllegalArgumentException("Invalid path")
          }
          node.copy(files = node.files.updated(head, updatedNode))
        case Nil => node
      }

      val parts = filePath.split("/").filter(_.nonEmpty).toList
      root = addContent(root, parts)
    }

    def readContentFromFile(filePath: String): String = {
      @scala.annotation.tailrec
      def getContent(node: Node, parts: List[String]): String = (node, parts) match {
        case (dir: DirNode, head :: tail) => getContent(dir.files(head), tail)
        case (FileNode(content), Nil) => content
        case _ => throw new IllegalArgumentException("Invalid path")
      }

      val parts = filePath.split("/").filter(_.nonEmpty).toList
      getContent(root, parts)
    }
  }
}
