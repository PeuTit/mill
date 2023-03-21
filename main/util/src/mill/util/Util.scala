package mill.util

import java.security.MessageDigest

object Util{
  def md5Hash(data: Iterator[Array[Byte]]) = {
    val digest = MessageDigest.getInstance("MD5")
    data.foreach(digest.update)
    digest.digest()
  }

  def isInteractive() = System.console() != null

  val windowsPlatform = System.getProperty("os.name").startsWith("Windows")

  val newLine = System.lineSeparator()
}
