import java.io.FileInputStream
import java.net.Socket
import java.nio.ByteBuffer

class Client(
    private val host: String,
    private val port: Int
) {
    fun start() {
        val socket = Socket(host, port)
        val outputStream = socket.getOutputStream()
        val file = FileInputStream("in.jpg")
        val size = file.available()
        println(size)
        outputStream.write(ByteBuffer.allocate(4).putInt(size).array())
        while (true) {
            val byte = file.read()
            if (byte == -1) {
                break
            }
            outputStream.write(byte)
        }
        outputStream.close()
        socket.close()
    }
}