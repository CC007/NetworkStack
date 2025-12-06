package com.github.cc007.poc.network

import java.net.Socket

fun main() {
    val socket = Socket("localhost", 8080)
    val writer = socket.getOutputStream().bufferedWriter()
    writer.write("a".repeat(1_000_000))
    writer.flush()
    socket.close()
}