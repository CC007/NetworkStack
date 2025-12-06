package com.github.cc007.poc.network

import java.net.ServerSocket
import java.net.SocketException

val buffer = ByteArray(4096)
fun main() {
    val sock = ServerSocket(8080)

    val client = sock.accept()
    val iStream = client.getInputStream()
    val oStream = client.getOutputStream()
    oStream.write("220 Welcome\n".toByteArray())

    var bytesRead = 0
    while (true) {
        val res: Int;
        try {
            res = iStream.read(buffer, 0, buffer.size)
        } catch (e: SocketException) {
            System.err.println("read: ${e.message}${e.cause?.message?.let { " ($it)" } ?: ""}")
            break;
        }
        if (res < 0) {
            System.err.println("read: $res")
            break;
        }
        if (res == 0) {
            break;
        }
        bytesRead += res
    }
    println(bytesRead)
}