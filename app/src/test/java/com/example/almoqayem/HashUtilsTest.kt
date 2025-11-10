package com.example.almoqayem

import com.example.almoqayem.utils.md5
import org.junit.Assert.assertEquals
import org.junit.Test

class HashUtilsTest {

    @Test
    fun md5_emptyString() {
        assertEquals("d41d8cd98f00b204e9800998ecf8427e", md5(""))
    }

    @Test
    fun md5_hello() {
        assertEquals("5d41402abc4b2a76b9719d911017c592", md5("hello"))
    }

    @Test
    fun md5_knownVector() {
        // md5 of "1234567890"
        assertEquals("e807f1fcf82d132f9bb018ca6738a19f", md5("1234567890"))
    }
}
