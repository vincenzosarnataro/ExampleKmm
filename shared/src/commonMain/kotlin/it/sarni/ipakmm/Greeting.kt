package it.sarni.ipakmm

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}