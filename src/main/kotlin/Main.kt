fun main() {
    val mode = readLine()!!
    if (mode == "server") {
        Server(1234).start()
    } else {
        Client("127.0.0.1", 1234).start()
    }
}