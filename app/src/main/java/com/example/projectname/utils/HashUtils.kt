package com.example.projectname.utils

import java.security.MessageDigest

fun md5(string: String): String {
    val md = MessageDigest.getInstance("MD5")
    val digest = md.digest(string.toByteArray())
    return digest.joinToString("") { "%02x".format(it) }
}

