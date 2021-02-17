import java.io.File
import java.net.ServerSocket
import java.nio.ByteBuffer

class Server(
    private val port: Int
) {
    fun start() {
        val serverSocket = ServerSocket(port)
        val socket = serverSocket.accept()
        val inputStream = socket.getInputStream()
        val sizeBuf = ByteArray(4)
        inputStream.read(sizeBuf)
        val size = ByteBuffer.wrap(sizeBuf).int
        println(size)
        val fileBuf = ByteArray(size)
        var offset = 0
        while (true) {
            val readSize = inputStream.read(fileBuf, offset, size - offset)
            if (readSize == 0) {
                break
            }
            offset += readSize
        }
        inputStream.close()
        socket.close()
        serverSocket.close()
        File("out.jpg").writeBytes(fileBuf)
    }
}